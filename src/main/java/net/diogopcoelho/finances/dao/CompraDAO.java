/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.dao;

import java.util.List;
import net.diogopcoelho.finances.entities.Compra;

/**
 *
 * @author diogo.coelho
 */
public interface CompraDAO {
    public Compra find(Long id);
    public List<Compra> listAll();
    public void add(Compra compra);
    public Compra refresh(Compra compra);
    public void update(Compra compra);
    public void remove(Compra compra);
}
