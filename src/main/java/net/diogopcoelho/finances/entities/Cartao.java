/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.diogopcoelho.finances.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author diogo.coelho
 */
@Entity
@Table(name = "CARTOES")
public class Cartao implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "CARTAO_ID")
    private Integer id;
    @Column(name = "CARTAO_BANDEIRA")
    private String bandeira;
    @Column(name = "CAETAO_VENCIMENTO")
    private Integer dia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer cartaoId) {
        this.id = cartaoId;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cartao)) {
            return false;
        }
        Cartao other = (Cartao) obj;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
