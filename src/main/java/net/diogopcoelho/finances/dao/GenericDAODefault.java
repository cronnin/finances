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
import javax.persistence.NoResultException;
import org.hibernate.Session;

/**
 *
 * @author diogo.coelho
 * @param <T>
 * @param <Pk>
 */
public abstract class GenericDAODefault<T extends Serializable, Pk extends Serializable>
        implements GenericDAO<T, Pk>{
    
    protected EntityManager entityManager;
    protected Class clazz;
    
    @Deprecated // CDI eyes only
    public GenericDAODefault() {
    }
    
    @Inject
    public GenericDAODefault(Class clazz, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }
    
    @Override
    public T find(Pk id) {
        try {
            return (T) getSession().load(clazz, id);
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<T> listAll() {
        return getSession().createCriteria(clazz).list();
    }

    @Override
    public void add(T registro) {
        entityManager.persist(registro);
    }

    @Override
    public T refresh(T registro) {
        getSession().refresh(registro); // You still can use Hibernate Session
        return registro;
    }

    @Override
    public void update(T registro) {
        entityManager.merge(registro);
    }

    @Override
    public void remove(T registro) {
        entityManager.remove(registro);
    }
    
    protected Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    
}
