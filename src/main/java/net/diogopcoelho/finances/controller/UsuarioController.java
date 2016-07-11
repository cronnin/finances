/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import javax.inject.Inject;
import net.diogopcoelho.finances.dao.UsuarioDAO;
import net.diogopcoelho.finances.entities.Usuario;

/**
 *
 * @author diogo.coelho
 */
@Path("/usuario")
@Controller
public class UsuarioController extends GenericController<Usuario, Long>{
    
    @Deprecated
    public UsuarioController() {
    }

    @Inject
    public UsuarioController(UsuarioDAO dao, Validator validator, Result result) {
        super(dao, validator, result);
    }

    @Override
    public void validar(Usuario registro) {
        //TODO
    }
    
}
