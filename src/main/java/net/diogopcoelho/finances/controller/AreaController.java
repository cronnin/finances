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
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
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
    
    @Inject
    Validator validator;
    
    
    @Get("/area/novo")
    public void formulario() {
    }

    @Get("/area/{id}")
    public Area formulario(Integer id) {
        return this.areaDAO.find(id);
    }

    @Put("/area/{id}")
    public void altera(Area area) {
        if(area.getDescricao() == null || area.getDescricao().isEmpty())
        {
            validator.add(new SimpleMessage("alerta", "O campo descrição deve ser preenchido"));
            validator.onErrorForwardTo(this).formulario(area.getId());
        }
        this.areaDAO.update(area);
        result.forwardTo(this).lista();
    }

    @Post("/area")
    public void adiciona(final Area area) {
        if(area.getDescricao() == null || area.getDescricao().isEmpty())
        {
            validator.add(new SimpleMessage("alerta", "O campo descrição deve ser preenchido"));
            validator.onErrorForwardTo(this).formulario();
        }
        this.areaDAO.add(area);
        result.forwardTo(this).lista();
    }

    @Delete("/area/{id}")
    public void remove(Integer id) {
        Area area = this.areaDAO.find(id);
        this.areaDAO.remove(area);
        result.forwardTo(this).lista();
    }

    @Get("/area")
    public List<Area> lista() {
        return this.areaDAO.listAll();
    }
    
    @Get("/buscaarea/{paginacao}/{descricao}")
    public List<Area> dataGridSelect(Integer paginacao, String descricao) {
        
        if(descricao==null || descricao.trim().isEmpty() || descricao.equals("null"))
                descricao = null;
         
        result.include("paginas",this.areaDAO.quantidade(paginacao, descricao));
        result.include("paginacao", paginacao);
        result.include("descricao", descricao);
        
        return this.areaDAO.list(paginacao,descricao);
    }
    
}
