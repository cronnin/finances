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
import net.diogopcoelho.finances.entities.Movimentacao;
import org.hibernate.Session;

/**
 *
 * @author CSI
 */
public class MovimentacaoDAODefault implements MovimentacaoDAO {
    private EntityManager entityManager;
    
    @Deprecated // CDI eyes only
    public MovimentacaoDAODefault() {
    }
    @Inject
    public MovimentacaoDAODefault(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public Movimentacao find(Integer id) {
        try {
            Movimentacao movimentacao = entityManager
                    .createQuery("select m from Movimentacao m where m.id = :id", Movimentacao.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return movimentacao;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Movimentacao> listAll() {
        return entityManager.createQuery("select m from Movimentacao m", Movimentacao.class).getResultList();
    }

    @Override
    public void add(Movimentacao movimentacao) {
        entityManager.persist(movimentacao);
    }

    @Override
    public Movimentacao refresh(Movimentacao movimentacao) {
        getSession().refresh(movimentacao); // You still can use Hibernate Session
        return movimentacao;
    }

    @Override
    public void update(Movimentacao movimentacao) {
        entityManager.merge(movimentacao);
    }

    @Override
    public void remove(Movimentacao movimentacao) {
        entityManager.remove(movimentacao);
    }
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
