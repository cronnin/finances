package com.financesm.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.financesm.core.annotation.CampoDB;
import com.financesm.core.annotation.CampoDB.TipoCampo;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by diogo.coelho on 14/03/2017.
 */

public abstract class Dao<T extends Serializable> extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "financesmdb";
    private static final int DATABASE_VERSION = 1;
    private final String DICTIONARY_TABLE_NAME;
    private final String DICTIONARY_TABLE_CREATE;

    public Dao(String dictionaryTableName, Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATA_BASE_NAME, factory, DATABASE_VERSION);
        this.DICTIONARY_TABLE_NAME = dictionaryTableName;
        DICTIONARY_TABLE_CREATE = "CREATE TABLE " + DICTIONARY_TABLE_NAME + " ( " +
               getCampos() + " );";
    }

    private String getCampos() {

        StringBuilder sb = new StringBuilder();

        Field[] campos = this.getClass().getDeclaredFields();

        for(Field f : campos){

            CampoDB a = (CampoDB)f.getAnnotation(CampoDB.class);

            sb.append(a.alias().isEmpty() ? f.getName().toUpperCase() : a.alias());
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

}