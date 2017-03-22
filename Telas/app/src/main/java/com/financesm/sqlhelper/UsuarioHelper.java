package com.financesm.sqlhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by diogo.coelho on 14/03/2017.
 */

public class UsuarioHelper extends AbstractHelper {

    public UsuarioHelper(Context context, SQLiteDatabase.CursorFactory factory) {
        super("USUARIOS", context, factory);
    }


}
