/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.diogopcoelho.finances.dao;

import java.util.List;
import net.diogopcoelho.finances.entities.Cartao;

/**
 *
 * @author CSI
 */
public interface CartaoDAO {
    public Cartao find(Integer id);
    
    public List<Cartao> listAll();
    
    public List<Cartao> list(int paginacao, String descricao);
    
    public int quantidade(int paginacao, String descricao);

    public void add(Cartao cartao);

    public Cartao refresh(Cartao cartao);

    public void update(Cartao cartao);

    public void remove(Cartao cartao);
}
