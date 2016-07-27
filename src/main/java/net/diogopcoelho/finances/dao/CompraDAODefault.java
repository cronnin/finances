/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.dao;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import net.diogopcoelho.finances.entities.Compra;
import org.hibernate.Session;

public class CompraDAODefault implements CompraDAO {

    private EntityManager entityManager;

    @Deprecated // CDI eyes only
    public CompraDAODefault() {
    }

    @Inject
    public CompraDAODefault(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Compra find(Long id) {
        try {
            Compra compra = entityManager
                    .createQuery("select c from Compra c where c.id = :id", Compra.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return compra;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Compra> listAll() {
        return entityManager.createQuery("select c from Compra c", Compra.class).getResultList();
    }

    @Override
    public void add(Compra compra) {
        entityManager.persist(compra);
    }

    @Override
    public Compra refresh(Compra compra) {
        getSession().refresh(compra); // You still can use Hibernate Session
        return compra;
    }

    @Override
    public void update(Compra compra) {
        entityManager.merge(compra);
    }

    @Override
    public void remove(Compra compra) {
        entityManager.remove(compra);
    }
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

}
