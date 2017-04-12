package com.financesm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.financesm.core.CampoForm;
import com.financesm.core.Util;
import com.financesm.core.annotation.CampoDB;
import com.financesm.core.db.Identificavel;
import com.financesm.sqlhelper.AbstractHelper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by diogo.coelho on 21/03/2017.
 */

public abstract class AbstractDao <T extends Identificavel> {

    private SQLiteDatabase database;
    private AbstractHelper dbHelper;
    private Class<T> clazz;

    public AbstractDao(Class<T> clazz){
        this.clazz = clazz;
        this.open();
    }

    public abstract void iniciarDbHelper(Context context) throws Exception;

    protected void iniciarDbHelper(AbstractHelper dbHelper){
        this.dbHelper = dbHelper;
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public T create(T registro) {

        ContentValues values = new ContentValues();

        inserirCampos(values, registro);

        long insertId =
                database.insert(dbHelper.DICTIONARY_TABLE_NAME, null,
                        values);
        Cursor cursor =
                database.query(dbHelper.DICTIONARY_TABLE_NAME,
                        dbHelper.arrayCampos,
                        dbHelper.DICTIONARY_ID_COLUMN + " = " + insertId, null,
                        null, null, null);
        cursor.moveToFirst();
        T newRegistro = cursorToRegistro(cursor);
        cursor.close();
        return newRegistro;
    }

    private void inserirCampos(ContentValues values, T registro) {

        for(CampoForm f : (List<CampoForm>)dbHelper.listaCampos){

            switch (f.getCampoDB().tipo()){
                case INTEIRO:
                    values.put( f.getAlias() ,
                            Util.getLongValue(clazz, f.getFieldName(), registro));
                    break;
                case DECIMAL:
                    values.put( f.getAlias() ,
                            Util.getDoubleValue(clazz, f.getFieldName(), registro));
                    break;
                case DATE:
                    values.put( f.getAlias() ,
                            Util.getDateValue(clazz, f.getFieldName(), registro));
                    break;
                case TEXT:
                    default:
                        values.put( f.getAlias() ,
                                Util.getStringValue(clazz, f.getFieldName(), registro));
            }

        }

    }

    public void delete(T registro) {
        long id = ((Identificavel)registro).getId();
        database.delete(dbHelper.DICTIONARY_TABLE_NAME,
                dbHelper.DICTIONARY_ID_COLUMN
                        + " = " + id, null);
    }

    public List<T> getAll() {

        List<T> registros = new ArrayList<>();

        Cursor cursor =
                database.query(dbHelper.DICTIONARY_TABLE_NAME,
                        dbHelper.arrayCampos, null, null, null,
                        null, null);

        cursor.moveToFirst();

        T registro;

        while (!cursor.isAfterLast()) {
            registro = cursorToRegistro(cursor);
            registros.add(registro);
            cursor.moveToNext();
        }

        cursor.close();

        return registros;
    }

    private T cursorToRegistro(Cursor cursor) {

        T registro = null;

        try {
            registro = clazz.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return registro;

    }

}
