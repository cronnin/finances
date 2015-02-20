/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import java.util.List;
import javax.inject.Inject;
import net.diogopcoelho.finances.dao.AreaDAO;
import net.diogopcoelho.finances.entities.Area;

/**
 *
 * @author coelho
 */
@Controller
public class AreaController {
    
    @Inject
    private Result result;
    
    @Inject
    private AreaDAO areaDAO;
    
    
    @Get("/area/novo")
    public void formulario() {
    }

    @Get("/area/{id}")
    public Area edita(Integer id) {
        return this.areaDAO.find(id);
    }

    @Put("/area/{area.id}")
    public void altera(Area area) {
        this.areaDAO.update(area);
    }

    @Post("/area")
    public void adiciona(final Area area) {
        this.areaDAO.add(area);
    }

    @Delete("/area/{id}")
    public void remove(Area area) {
        this.areaDAO.remove(area);
    }

    @Get("/area")
    public List<Area> lista() {
        return this.areaDAO.listAll();
    }
    
}
