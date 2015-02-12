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

    private final Result result;
    private final MovimentacaoDAO movimentacaoDAO;
    

    /**
     * @deprecated CDI eyes only
     */
    protected MovimentacaoController() {
        this(null,null);
    }

    @Inject
    public MovimentacaoController(Result result,MovimentacaoDAO movimentacaoDAO) {
        this.result = result;
        this.movimentacaoDAO = movimentacaoDAO;
    }

    @Get("/movimentacao/novo")
    public void formulario() {
    }

    @Get("/movimentacao/{id}")
    public Movimentacao edita(Integer id) {
        return this.movimentacaoDAO.getReference(id);
    }

    @Put("/movimentacao/{produto.id}")
    public void altera(Movimentacao produto) {
        this.movimentacaoDAO.salvar(produto);
    }

    @Post("/movimentacao")
    public void adiciona(final Movimentacao produto) {
        this.movimentacaoDAO.salvar(produto);
    }

    @Delete("/movimentacao/{id}")
    public void remove(Integer id) {
        this.movimentacaoDAO.removeEntity(id);
    }

    @Get("/movimentacao")
    public List<Movimentacao> lista() {
        return this.movimentacaoDAO.findAll();
    }

}
