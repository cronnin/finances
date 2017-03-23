package com.financesm.model;

import com.financesm.core.db.Identificavel;

import java.io.Serializable;

/**
 * Created by diogo.coelho on 14/03/2017.
 */

public class Usuario implements Serializable,Identificavel {


    private Long id;
    private String login;
    private String nome;

    @Override
    public Long getId() {

        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
