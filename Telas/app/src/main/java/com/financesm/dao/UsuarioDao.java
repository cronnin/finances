package com.financesm.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by diogo.coelho on 14/03/2017.
 */

public class UsuarioDao extends Dao {

    public UsuarioDao(Context context, SQLiteDatabase.CursorFactory factory) {
        super("USUARIOS", context, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
