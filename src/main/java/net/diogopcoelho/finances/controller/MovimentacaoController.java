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
import net.diogopcoelho.finances.dao.MovimentacaoDAO;
import net.diogopcoelho.finances.entities.Movimentacao;

/**
 *
 * @author coelho
 */
@Controller
public class MovimentacaoController {
    
    @Inject
    private Result result;
    
    @Inject
    private MovimentacaoDAO movimentacaoDAO;
   

    @Get("/movimentacao/novo")
    public void formulario() {
    }

    @Get("/movimentacao/{id}")
    public Movimentacao edita(Integer id) {
        return this.movimentacaoDAO.find(id);
    }

    @Put("/movimentacao/{produto.id}")
    public void altera(Movimentacao produto) {
        this.movimentacaoDAO.update(produto);
    }

    @Post("/movimentacao")
    public void adiciona(final Movimentacao produto) {
        this.movimentacaoDAO.add(produto);
    }

    @Delete("/movimentacao/{id}")
    public void remove(Movimentacao movimentacao) {
        this.movimentacaoDAO.remove(movimentacao);
    }

    @Get("/movimentacao")
    public List<Movimentacao> lista() {
        return this.movimentacaoDAO.listAll();
    }

}
