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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author diogo.coelho
 */
@Entity
@Table(name = "FORMA_PAGAMENTO")
public class FormaPagamento implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "FORMPGMNT_ID")
    private Integer id;
    @Column(name = "FORMPGMNT_DESCRICAO")
    private String descricao;
    @Column(name = "FORMPGMNT_FORMULA")
    private String formula;
    @ManyToOne
    @JoinColumn(name = "CARTAO_ID")
    private Cartao cartao;
    @ManyToOne
    @JoinColumn(name = "COMPRA_ID")
    private Compra compra;
    @OneToOne
    @JoinColumn(name = "MOVIMENTACAO_ID")
    private Movimentacao movimentacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }
    
}
