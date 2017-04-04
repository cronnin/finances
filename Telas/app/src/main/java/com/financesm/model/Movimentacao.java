package com.financesm.model;

import com.financesm.core.annotation.CampoDB;
import com.financesm.core.db.Identificavel;

import java.io.Serializable;

/**
 * Created by diogo.coelho on 14/03/2017.
 */

public class Movimentacao implements Serializable, Identificavel {

    @CampoDB(tipo = CampoDB.TipoCampo.INTEIRO)
    private Long id;
    @CampoDB(tipo = CampoDB.TipoCampo.DECIMAL)
    private Double valor;
    @CampoDB(tipo = CampoDB.TipoCampo.TEXT)
    private String descricao;
    @CampoDB(tipo = CampoDB.TipoCampo.INTEIRO)
    private TipoMovimentacao tipo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
