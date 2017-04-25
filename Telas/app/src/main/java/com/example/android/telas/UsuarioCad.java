package com.example.android.telas;

import android.net.Uri;

import com.financesm.core.db.Identificavel;
import com.financesm.dao.MovimentacaoDao;
import com.financesm.dao.UsuarioDao;
import com.financesm.model.Movimentacao;
import com.financesm.model.Usuario;

/**
 * Created by diogo.coelho on 12/04/2017.
 */

public class UsuarioCad extends CadastroActivity<Usuario> {

    public UsuarioCad() {
        super(Movimentacao.class, new UsuarioDao());
    }

}
