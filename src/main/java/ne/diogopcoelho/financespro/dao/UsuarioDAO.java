/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ne.diogopcoelho.financespro.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import ne.diogopcoelho.financespro.entity.Usuario;

/**
 *
 * @author diogo.coelho
 */
@RequestScoped
public class UsuarioDAO extends GenericDAO<Usuario,Long> {
    
    @Inject
    public UsuarioDAO(EntityManager entityManager) {
        super(Usuario.class, entityManager);
    }
    
}
