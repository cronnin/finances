package com.financesm.model;

import java.io.Serializable;

/**
 * Created by diogo.coelho on 14/03/2017.
 */

public class Usuario implements Serializable {


    private int id;
    private String login;
    private String nome;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
