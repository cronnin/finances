package com.financesm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.financesm.core.annotation.CampoDB;
import com.financesm.core.db.Identificavel;
import com.financesm.sqlhelper.AbstractHelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by diogo.coelho on 21/03/2017.
 */

public abstract class AbstractDao <T extends Identificavel> {

    private SQLiteDatabase database;
    private AbstractHelper dbHelper;
    private Class<T> clazz;

    public AbstractDao(AbstractHelper dbHelper, Class<T> clazz){
        this.dbHelper = dbHelper;
        this.clazz = clazz;
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public T create(T registro) {

        ContentValues values = new ContentValues();

        inserirCampos(values);

        long insertId =
                database.insert(dbHelper.DICTIONARY_TABLE_NAME, null,
                        values);
        Cursor cursor =
                database.query(dbHelper.DICTIONARY_TABLE_NAME,
                        dbHelper.getArrayCampos(),
                        dbHelper.DICTIONARY_ID_COLUMN + " = " + insertId, null,
                        null, null, null);
        cursor.moveToFirst();
        T newRegistro = cursorToRegistro(cursor);
        cursor.close();
        return newRegistro;
    }

    private void inserirCampos(ContentValues values, T registro) {

        Field[] campos = clazz.getDeclaredFields();
        CampoDB c;
        for(Field f : campos){

            c = f.getAnnotation(CampoDB.class);
            if(c != null) {

                values.put( (c.alias().isEmpty() ? f.getName() : c.alias()) ,
                        getFielValue(f, registro));

            }
        }

    }

    private String getFielValue(Field f, T registro) {

        return null;
    }

    public void deleteComment(T registro) {
        long id = ((Identificavel)registro).getId();
        database.delete(dbHelper.DICTIONARY_TABLE_NAME,
                dbHelper.DICTIONARY_ID_COLUMN
                        + " = " + id, null);
    }

    public List<T> getAllComments() {

        List<T> registros = new ArrayList<>();

        Cursor cursor =
                database.query(dbHelper.DICTIONARY_TABLE_NAME,
                        dbHelper.getArrayCampos(), null, null, null,
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
