package com.financesm.sqlhelper;

import android.content.Context;

import com.financesm.dao.AbstractDao;
import com.financesm.model.Movimentacao;

/**
 * Created by diogo.coelho on 03/04/2017.
 */

public class MovimentacaoHelper extends AbstractHelper<Movimentacao> {
    public MovimentacaoHelper(Context context) {
        super("MOVIMENTACAO", "ID_MOVIMENTACAO", context);
    }
}
