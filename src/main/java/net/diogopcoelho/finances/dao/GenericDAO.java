/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
/**
 *
 * @author CSI
 */
public abstract class GenericDAO<T extends Serializable, PK extends Serializable> {

    private EntityManager em;
    private final Class<T> tipoClass;

    @SuppressWarnings("unchecked")
    public GenericDAO() {
        tipoClass = (Class<T>) ((ParameterizedType) 
                getClass().getGenericSuperclass()).getActualTypeArguments()[ 0];
    }

    protected List<T> findAll() {
        CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(tipoClass);
        cq.from(tipoClass);
        return em.createQuery(cq).getResultList();
    }

    protected T getReference(PK pk) {
        return (T) em.getReference(this.tipoClass, pk);
    }

    protected <E extends Serializable> E mergeEntity(E entity) {
        E retorno = em.merge(entity);
        em.flush();
        return retorno;
    }

    protected <E extends Serializable> E mergeEntityWithRefresh(E entity) {
        E retorno = em.merge(entity);
        em.flush();
        em.refresh(retorno);
        return retorno;
    }

    protected T refreshEntity(PK pk) {
        T t = (T) em.find(this.tipoClass, pk);
        if (t != null) {
            em.refresh(t);
        }
        return t;
    }

    protected void removeEntity(PK pk) {
        em.remove(getReference(pk));
    }


}
