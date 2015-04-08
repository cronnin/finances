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
import net.diogopcoelho.finances.dao.CartaoDAO;
import net.diogopcoelho.finances.entities.Cartao;

/**
 *
 * @author diogo.coelho
 */
@Controller
public class CartaoController {
    
    @Inject
    private Result result;
    
    @Inject
    private CartaoDAO cartaoDAO;
    
    @Inject
    private Validator validator;
    
    @Get("/cartao/novo")
    public void formulario() {
    }

    @Get("/cartao/{id}")
    public Cartao formulario(Integer id) {
        return this.cartaoDAO.find(id);
    }

    @Put("/cartao/{id}")
    public void altera(Cartao area) {
        if(area.getDescricao() == null || area.getDescricao().isEmpty())
        {
            validator.add(new SimpleMessage("alerta", "O campo descrição deve ser preenchido"));
            validator.onErrorForwardTo(this).formulario(area.getId());
        }
        this.cartaoDAO.update(area);
        result.forwardTo(this).lista();
    }

    @Post("/cartao")
    public void adiciona(final Cartao area) {
        if(area.getDescricao() == null || area.getDescricao().isEmpty())
        {
            validator.add(new SimpleMessage("alerta", "O campo descrição deve ser preenchido"));
            validator.onErrorForwardTo(this).formulario();
        }
        this.cartaoDAO.add(area);
        result.forwardTo(this).lista();
    }

    @Delete("/cartao/{id}")
    public void remove(Integer id) {
        Cartao area = this.cartaoDAO.find(id);
        this.cartaoDAO.remove(area);
        result.forwardTo(this).lista();
    }

    @Get("/cartao")
    public List<Cartao> lista() {
        return this.cartaoDAO.listAll();
    }
    
    @Get("/buscacartao/{paginacao}/{descricao}")
    public List<Cartao> dataGridSelect(Integer paginacao, String descricao) {
        
        if(descricao==null || descricao.trim().isEmpty() || descricao.equals("null"))
                descricao = null;
         
        result.include("paginas",this.cartaoDAO.quantidade(paginacao, descricao));
        result.include("paginacao", paginacao);
        result.include( "descricao", descricao);
        
        return this.cartaoDAO.list(paginacao,descricao);
    }
    
}
