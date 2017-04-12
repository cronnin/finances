package com.financesm.sqlhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.financesm.core.CampoForm;
import com.financesm.core.Util;
import com.financesm.core.annotation.CampoDB;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by diogo.coelho on 14/03/2017.
 */

public abstract class AbstractHelper<T extends Serializable> extends SQLiteOpenHelper {

    public static final String DATA_BASE_NAME = "financesmdb";
    public static final int DATABASE_VERSION = 1;
    public final String DICTIONARY_TABLE_NAME;
    public final String DICTIONARY_ID_COLUMN;
    public final String DICTIONARY_TABLE_CREATE;

    public List<CampoForm> listaCampos;
    public String[] arrayCampos;

    public AbstractHelper(String dictionaryTableName, String idColumn, Context context) throws Exception {

        super(context, DATA_BASE_NAME, null, DATABASE_VERSION);

        Class clazz = null;

        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();

        if(type != null && type.getActualTypeArguments().length > 0)
                clazz = (Class)type.getActualTypeArguments()[0];

        if(clazz == null)
            throw new Exception("Esse objeto não possui tipo.");

        this.listaCampos = Util.getCampos(clazz);

        this.arrayCampos = getArrayCampos();

        this.DICTIONARY_TABLE_NAME = dictionaryTableName;
        this.DICTIONARY_ID_COLUMN = idColumn;

        DICTIONARY_TABLE_CREATE = "CREATE TABLE " + DICTIONARY_TABLE_NAME + " ( " +
               getCampos(clazz) + " );";
    }

    private String[] getArrayCampos() {
        String[] campos = new String[this.listaCampos.size()];
        int i = 0;
        for(CampoForm cf : this.listaCampos){
            campos[i] = cf.getAlias();
            i++;
        }
        return campos;
    }

    public String getCampos(Class clazz) {

        StringBuilder sb = new StringBuilder();

        for(CampoForm f : this.listaCampos){

            sb.append(f.getAlias());
            sb.append(" ");

            switch (f.getCampoDB().tipo()){
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