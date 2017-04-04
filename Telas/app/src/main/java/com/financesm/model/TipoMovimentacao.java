package com.financesm.model;

/**
 * Created by diogo.coelho on 03/04/2017.
 */

public enum TipoMovimentacao {
    CREDITO(1l,"Crédito"), DEBITO(2l,"Débito");

    private String tipo;
    private Long id;
    private TipoMovimentacao(Long id, String tipo){
        this.tipo = tipo;
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }
    public String getTipo(){
        return this.tipo;
    }
}
