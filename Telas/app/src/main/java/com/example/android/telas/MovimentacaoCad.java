package com.example.android.telas;

import com.financesm.dao.AbstractDao;
import com.financesm.dao.MovimentacaoDao;
import com.financesm.model.Movimentacao;

/**
 * Created by diogo.coelho on 12/04/2017.
 */

public class MovimentacaoCad extends CadastroActivity<Movimentacao> {

    public MovimentacaoCad() {
        super(Movimentacao.class, new MovimentacaoDao());
    }

}
