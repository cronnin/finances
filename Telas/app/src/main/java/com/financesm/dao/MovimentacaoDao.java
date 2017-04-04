package com.financesm.dao;

import android.content.Context;

import com.financesm.model.Movimentacao;
import com.financesm.sqlhelper.AbstractHelper;
import com.financesm.sqlhelper.MovimentacaoHelper;

/**
 * Created by diogo.coelho on 03/04/2017.
 */

public class MovimentacaoDao extends AbstractDao<Movimentacao> {
    public MovimentacaoDao(Context context) {
        super(new MovimentacaoHelper(context), Movimentacao.class);
    }
}
