/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.diogopcoelho.finances.entities.enuns;

/**
 *
 * @author diogo.coelho
 */
public enum TipoEntrada {
    CREDITO(1,"Crédito"), DEBITO(2,"Débito");
    
    private int id;
    private String descricao;
    
    private TipoEntrada(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
