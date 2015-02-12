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
 * @author CSI
 */
public class MovimentacaoDAO extends GenericDAO<Movimentacao, Integer> {
    
    @Override
    public List<Movimentacao> findAll(){
        return super.findAll();
    }

    @Override
    public Movimentacao getReference(Integer pk) {
        return super.getReference(pk);
    }

    public Movimentacao salvar(Movimentacao entity) {
       return super.mergeEntityWithRefresh(entity);
    }

    @Override
    public void removeEntity(Integer pk) {
        super.removeEntity(pk);
    }
    
}
