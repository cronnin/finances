/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.dao;

import java.util.List;
import net.diogopcoelho.finances.entities.Movimentacao;

/**
 *
 * @author coelho
 */
public interface MovimentacaoDAO {
    public Movimentacao find(Long id);
    public List<Movimentacao> listAll();
    public void add(Movimentacao movimentacao);
    public Movimentacao refresh(Movimentacao movimentacao);
    public void update(Movimentacao movimentacao);
    public void remove(Movimentacao movimentacao);
}
