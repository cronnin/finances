/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.diogopcoelho.finances.dao;

import java.util.List;
import net.diogopcoelho.finances.entities.Movimentacao;
import net.diogopcoelho.finances.entities.Parcela;

/**
 *
 * @author CSI
 */
public interface ParcelaDAO {
    public Parcela find(Integer id);
    public List<Parcela> listAll();
    public void add(Parcela parcela);
    public Parcela refresh(Parcela parcela);
    public void update(Parcela parcela);
    public void remove(Parcela parcela);
}
