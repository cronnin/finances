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
import net.diogopcoelho.finances.entities.Parcela;
import org.hibernate.Session;

/**
 *
 * @author diogo.coelho
 */
public class ParcelaDAODefault implements ParcelaDAO {

    private EntityManager entityManager;
    
    @Deprecated // CDI eyes only
    public ParcelaDAODefault() {
    }
    
    @Inject
    public ParcelaDAODefault(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public Parcela find(Long id) {
        try {
            Parcela parcela = entityManager
                    .createQuery("select m from Movimentacao m where m.id = :id", Parcela.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return parcela;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Parcela> listAll() {
        return entityManager.createQuery("select m from Parcela m", Parcela.class).getResultList();
    }

    @Override
    public void add(Parcela parcela) {
        entityManager.persist(parcela);
    }

    @Override
    public Parcela refresh(Parcela parcela) {
        getSession().refresh(parcela); // You still can use Hibernate Session
        return parcela;
    }

    @Override
    public void update(Parcela parcela) {
        entityManager.merge(parcela);
    }

    @Override
    public void remove(Parcela parcela) {
        entityManager.remove(parcela);
    }
    
     private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
