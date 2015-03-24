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
import org.hibernate.Session;

/**
 *
 * @author CSI
 */
public class AreaDAODefault implements AreaDAO {

    private EntityManager entityManager;

    @Deprecated // CDI eyes only
    public AreaDAODefault() {
    }

    @Inject
    public AreaDAODefault(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Area find(Integer id) {
        try {
            Area area = entityManager
                    .createQuery("select a from Area a where a.id = :id", Area.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return area;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Area> listAll() {
        return entityManager.createQuery("select a from Area a", Area.class).getResultList();
    }

    @Override
    public List<Area> list(int paginacao, String descricao) {
        List<Area> a = construirConsulta(descricao)
                .setFirstResult(((paginacao - 1) * 10))
                .setMaxResults(10)
                .getResultList();
        return a;
    }
    
    @Override
    public int quantidade(int paginacao, String descricao) {
        int a = (int)Math.ceil(construirConsulta(descricao)
                .getResultList().size() / 10.00);
        return a;
    }
    
    public Query construirConsulta(String descricao){
        String sql =  " select a from Area a ";
        
        if (descricao != null && !descricao.trim().isEmpty()) {
            sql += " where a.descricao like :descricao ";
        }
        
        Query query = entityManager.createQuery(sql, Area.class);
        
        if(descricao != null && !descricao.trim().isEmpty())
        {
            query.setParameter("descricao", descricao);
        }
        return query;
    }

    @Override
    public void add(Area area) {
        entityManager.persist(area);
    }

    @Override
    public Area refresh(Area area) {
        getSession().refresh(area); // You still can use Hibernate Session
        return area;
    }

    @Override
    public void update(Area area) {
        entityManager.merge(area);
    }

    @Override
    public void remove(Area area) {
        entityManager.remove(area);
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
