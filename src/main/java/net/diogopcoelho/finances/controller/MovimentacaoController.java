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
import net.diogopcoelho.finances.dao.MovimentacaoDAO;
import net.diogopcoelho.finances.entities.Movimentacao;
import net.diogopcoelho.finances.entities.enuns.TipoEntrada;

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

    @Inject
    private AreaDAO areaDAO;

    @Inject
    Validator validator;

    @Get("/movimentacao/novo")
    public void formulario() {
        result.include("areasList", areaDAO.listAll());
        result.include("tipos", TipoEntrada.values());
    }

    @Get("/movimentacao/{id}")
    public Movimentacao formulario(Long id) {
        validator.onErrorUsePageOf(this).lista();
        result.include("areasList", areaDAO.listAll());
        result.include("tipos", TipoEntrada.values());
        return this.movimentacaoDAO.find(id);
    }

    @Put("/movimentacao/{produto.id}")
    public void altera(Movimentacao movimentacao) {
        validator.onErrorUsePageOf(this).lista();
        if (movimentacao.getDescricao() == null || movimentacao.getDescricao().isEmpty()) {
            validator.add(new SimpleMessage("alerta", "O campo descrição deve ser preenchido"));
            validator.onErrorForwardTo(this).formulario();
        }
        this.movimentacaoDAO.update(movimentacao);
        result.forwardTo(this).lista();
    }

    @Post("/movimentacao")
    public void adiciona(final Movimentacao movimentacao) {
        validator.onErrorUsePageOf(this).lista();
        if (movimentacao.getDescricao() == null || movimentacao.getDescricao().isEmpty()) {
            validator.add(new SimpleMessage("alerta", "O campo descrição deve ser preenchido"));
            validator.onErrorForwardTo(this).formulario();
        }
        this.movimentacaoDAO.add(movimentacao);
        result.forwardTo(this).lista();
    }

    @Delete("/movimentacao/{id}")
    public void remove(Long id) {
        validator.onErrorUsePageOf(this).lista();
        Movimentacao movimentacao = this.movimentacaoDAO.find(id);
        this.movimentacaoDAO.remove(movimentacao);
        result.forwardTo(this).lista();
    }

    @Get("/movimentacao")
    public List<Movimentacao> lista() {
        List<Movimentacao> m = this.movimentacaoDAO.listAll();
        return m;
    }

}
