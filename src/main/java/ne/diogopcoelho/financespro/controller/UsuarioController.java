/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ne.diogopcoelho.financespro.controller;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import ne.diogopcoelho.financespro.dao.UsuarioDAO;
import ne.diogopcoelho.financespro.entity.Usuario;

/**
 *
 * @author diogo.coelho
 */
@WebServlet(urlPatterns = {"/usuario/*"})
public class UsuarioController extends GenericController<Usuario, Long>{

    @Inject
    public UsuarioController(UsuarioDAO dao) {
        super(Usuario.class, dao);
    }
    
}
