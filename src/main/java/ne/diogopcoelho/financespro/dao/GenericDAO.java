/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ne.diogopcoelho.financespro.dao;

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
public class GenericDAO<T extends Serializable, Pk extends Serializable> {

    protected EntityManager entityManager;
    protected Class clazz;
    
    @Inject
    public GenericDAO(Class clazz, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }
    
    public T find(Pk id) {
        try {
            return (T) getSession().load(clazz, id);
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<T> listAll() {
        return getSession().createCriteria(clazz).list();
    }

    public void add(T registro) {
        entityManager.persist(registro);
    }

    public T refresh(T registro) {
        getSession().refresh(registro); // You still can use Hibernate Session
        return registro;
    }
    
    public void update(T registro) {
        entityManager.merge(registro);
    }

    public void remove(T registro) {
        entityManager.remove(registro);
    }
    
    protected Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
