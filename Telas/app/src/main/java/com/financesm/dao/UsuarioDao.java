package com.financesm.dao;

import android.content.Context;

import com.financesm.model.Usuario;
import com.financesm.sqlhelper.AbstractHelper;
import com.financesm.sqlhelper.UsuarioHelper;

/**
 * Created by diogo.coelho on 23/03/2017.
 */

public class UsuarioDao extends AbstractDao<Usuario> {

    public UsuarioDao() {
        super(Usuario.class);
    }

    @Override
    public void iniciarDbHelper(Context context) throws Exception {
        super.iniciarDbHelper(new UsuarioHelper(context));
    }
}
