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
import javax.persistence.Query;
import net.diogopcoelho.finances.entities.Area;
import net.diogopcoelho.finances.entities.Cartao;
import org.hibernate.Session;

/**
 *
 * @author diogo.coelho
 */
public class CartaoDAODefault implements CartaoDAO{
    private EntityManager entityManager;

    @Deprecated // CDI eyes only
    public CartaoDAODefault() {
    }

    @Inject
    public CartaoDAODefault(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Cartao> listAll() {
        return entityManager.createQuery("select c from Cartao c", Cartao.class).getResultList();
    }

    @Override
    public List<Cartao> list(int paginacao, String descricao) {
        List<Cartao> c = construirConsulta(descricao)
                .setFirstResult(((paginacao - 1) * 10))
                .setMaxResults(10)
                .getResultList();
        return c;
    }

    @Override
    public int quantidade(int paginacao, String descricao) {
        int c = (int)Math.ceil(construirConsulta(descricao)
                .getResultList().size() / 10.00);
        return c;
    }
    
    private Query construirConsulta(String descricao){
        String sql =  " select c from Cartao c ";
        
        if (descricao != null && !descricao.trim().isEmpty()) {
            sql += " where c.descricao like :descricao ";
        }
        
        Query query = entityManager.createQuery(sql, Cartao.class);
        
        if(descricao != null && !descricao.trim().isEmpty())
        {
            query.setParameter("descricao", descricao);
        }
        return query;
    }

    @Override
    public void add(Cartao cartao) {
        entityManager.persist(cartao);
    }

    @Override
    public Cartao refresh(Cartao cartao) {
        getSession().refresh(cartao); // You still can use Hibernate Session
        return cartao;
    }

    @Override
    public void update(Cartao cartao) {
        entityManager.merge(cartao);
    }

    @Override
    public void remove(Cartao cartao) {
        entityManager.remove(cartao);
    }
    
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public Cartao find(Integer id) {
        try {
            Cartao cartao = entityManager
                    .createQuery("select c from Cartao c where c.id = :id", Cartao.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return cartao;
        } catch (NoResultException e) {
            return null;
        }
    }
}
