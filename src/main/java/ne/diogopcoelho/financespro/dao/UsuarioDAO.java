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
import org.hibernate.Session;

/**
 *
 * @author diogo.coelho
 */
@RequestScoped
public class UsuarioDAO extends GenericDAO<Usuario,Long> {

    @Deprecated
    public UsuarioDAO() {
        super(null, null);
    }
    
    @Inject
    public UsuarioDAO(Session entityManager) {
        super(Usuario.class, entityManager);
    }
    
}
