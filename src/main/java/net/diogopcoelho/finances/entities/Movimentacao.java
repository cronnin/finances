/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.diogopcoelho.finances.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import net.diogopcoelho.finances.entities.enuns.TipoEntrada;

/**
 *
 * @author diogo.coelho
 */
@Entity
@Table(name = "MOVIMENTACOES")
public class Movimentacao implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "MOVIMENTACAO_ID")
    private Integer id;
    @Column(name = "MOVIMENTACAO_DESCRICAO")
    private String descricao;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "MOVIMENTACAO_AREA")
    private Area area;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "MOVIMENTACAO_CARTAO")
    private Cartao cartao;
    @Column(name = "MOVIMENTACAO_TIPO")
    @Enumerated(EnumType.STRING)
    private TipoEntrada tipoEntrada;
    @Column(name = "MOVIMENTACAO_VALOR")
    private double valor;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "movimentacao")
    private Collection<Parcela> parcelas;
    @Temporal(TemporalType.DATE)
    @Column(name = "MOVIMENTACAO_DATA")
    private Calendar data;
    @Temporal(TemporalType.DATE)
    @Column(name = "MOVIMENTACAO_PAGAMENTO")
    private Calendar pagemento;
    @Column(name = "MOVIMENTACAO_QUITADO")
    private boolean quitado;
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) obj;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Collection<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(Collection<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    public Calendar getData() {
        return data;
    }
    
    public String getDataFormatada() {
        if(data == null)
            return "";
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data.getTime());
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getPagemento() {
        return pagemento;
    }

    public void setPagemento(Calendar pagemento) {
        this.pagemento = pagemento;
    }

    public boolean isQuitado() {
        return quitado;
    }

    public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }
}
