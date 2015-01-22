/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.diogopcoelho.finances.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diogo.coelho
 */
@Entity
@Table(name = "PARCELAS")
public class Parcela  implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "PARCELA_ID")
    private Integer id;
    @Column(name = "PARCELA_VALOR")
    private double valor;
    @Temporal(TemporalType.DATE)
    @Column(name = "PARCELA_VENCIMENTO")
    private Calendar vencimento;
    @Column(name = "PARCELA_PAGO")
    private boolean pago;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "MOVIMENTACAO_ID")
    private Movimentacao movimentacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Parcela)) {
            return false;
        }
        Parcela other = (Parcela) obj;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }
}
