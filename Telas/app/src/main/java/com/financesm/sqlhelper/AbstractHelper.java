package com.financesm.sqlhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.financesm.core.annotation.CampoDB;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Created by diogo.coelho on 14/03/2017.
 */

public abstract class AbstractHelper<T extends Serializable> extends SQLiteOpenHelper {

    public static final String DATA_BASE_NAME = "financesmdb";
    public static final int DATABASE_VERSION = 1;
    public final String DICTIONARY_TABLE_NAME;
    public final String DICTIONARY_ID_COLUMN;
    public final String DICTIONARY_TABLE_CREATE;

    public AbstractHelper(String dictionaryTableName, String idColumn, Context context) {
        super(context, DATA_BASE_NAME, null, DATABASE_VERSION);
        this.DICTIONARY_TABLE_NAME = dictionaryTableName;
        this.DICTIONARY_ID_COLUMN = idColumn;
        DICTIONARY_TABLE_CREATE = "CREATE TABLE " + DICTIONARY_TABLE_NAME + " ( " +
               getCampos() + " );";
    }

    public String[] getArrayCampos() {
        return null;
    }

    public String getCampos() {

        StringBuilder sb = new StringBuilder();

        Field[] campos = this.getClass().getDeclaredFields();

        for(Field f : campos){

            CampoDB a = (CampoDB)f.getAnnotation(CampoDB.class);

            sb.append(a.alias() == null || a.alias().isEmpty() ? f.getName().toUpperCase() : a.alias());
            sb.append(" ");

            switch (a.tipo()){
                case INTEIRO:
                    sb.append("INTEGER");
                    break;
                case DECIMAL:
                    sb.append("REAL");
                    break;
                case DATE:
                    sb.append("ITEGER");
                    break;
                case TEXT:
                default:
                    sb.append("TEXT");
                    break;
            }

        }

        return sb.toString();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + this.DICTIONARY_TABLE_NAME);
        onCreate(db);
    }





}