/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author diogo.coelho
 */
public interface GenericoDAO<E extends Serializable, PK extends Serializable> {
    
    public List<?> findAll();

    public E getReference(PK pk);

    public E mergeEntity(E entity);

    public E mergeEntityWithRefresh(E entity);

    public E refreshEntity(PK pk);

    public void removeEntity(PK pk);
    
}
