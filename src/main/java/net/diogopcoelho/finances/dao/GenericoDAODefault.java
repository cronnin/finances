/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author diogo.coelho
 * @param <T>
 * @param <Pk>
 */
public class GenericoDAODefault<T extends Serializable, Pk extends Serializable> implements GenericoDAO<T,Pk> {
    
    private EntityManager em;
    private Class<T> tipoClass;
    private Class<Pk> tipoPk;
    
    @Deprecated // CDI eyes only
    public GenericoDAODefault() {
    }
    
    @Inject
    public GenericoDAODefault(EntityManager em, Class<T> tipoClass, Class<Pk> tipoPk){
        this.em = em;
        this.tipoClass = tipoClass;
        this.tipoPk = tipoPk;
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(tipoClass);
        cq.from(tipoClass);
        return em.createQuery(cq).getResultList();
    }

    @Override
    public T getReference(Pk pk) {
        return (T) em.getReference(this.tipoClass, pk);
    }

    @Override
    public T mergeEntity(T entity) {
        T retorno = em.merge(entity);
        em.flush();
        return retorno;
    }

    @Override
    public T mergeEntityWithRefresh(T entity) {
        T retorno = em.merge(entity);
        em.flush();
        em.refresh(retorno);
        return retorno;
    }

    @Override
    public T refreshEntity(Pk pk) {
        T t = (T) em.find(this.tipoClass, pk);
        if (t != null) {
            em.refresh(t);
        }
        return t;
    }

    @Override
    public void removeEntity(Pk pk) {
        em.remove(getReference(pk));
    }
    
}
