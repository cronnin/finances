/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author diogo.coelho
 */
@Entity
@Table(name = "COMPRAS")
public class Compra implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "COMPRA_ID")
    private Long id;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "compra")
    private final List<Parcela> parcelas = new ArrayList<>();
    @ManyToOne
    @JoinColumn(columnDefinition = "CARTAO_ID")
    private Cartao cartao;
    @OneToOne
    @JoinColumn(columnDefinition = "MOVIMENTACAO_ID")
    private Movimentacao movimentacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }
    
    
}
