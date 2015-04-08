/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import java.util.List;
import javax.inject.Inject;
import net.diogopcoelho.finances.dao.GenericoDAO;
import net.diogopcoelho.finances.entities.Area;

@Controller
public class TesteController {

    @Inject
    private Result result;
    
    @Inject
    private GenericoDAO<Area, Integer> areaDAO;

    @Get("/teste")
    public List<Area> lista() {
        return (List<Area>)this.areaDAO.findAll();
    }
}
