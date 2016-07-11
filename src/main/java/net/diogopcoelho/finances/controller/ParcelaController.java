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
import br.com.caelum.vraptor.validator.Validator;
import java.util.List;
import javax.inject.Inject;
import net.diogopcoelho.finances.dao.ParcelaDAO;
import net.diogopcoelho.finances.entities.Parcela;

/**
 *
 * @author diogo.coelho
 */
@Controller
public class ParcelaController {

    @Inject
    private Result result;

    @Inject
    private ParcelaDAO parcelaDAO;

    @Inject
    Validator validator;

    @Get("/parcela/novo")
    public void formulario() {
    }

    @Get("/parcela/{id}")
    public Parcela formulario(Integer id) {
        validator.onErrorUsePageOf(this).lista();
        return this.parcelaDAO.find(id);
    }

    @Put("/parcela/{produto.id}")
    public void altera(Parcela movimentacao) {
        this.parcelaDAO.update(movimentacao);
        result.forwardTo(this).lista();
    }

    @Post("/parcela")
    public void adiciona(final Parcela movimentacao) {
        this.parcelaDAO.add(movimentacao);
        result.forwardTo(this).lista();
    }

    @Delete("/parcela/{id}")
    public void remove(Integer id) {
        validator.onErrorUsePageOf(this).lista();
        Parcela parcela = this.parcelaDAO.find(id);
        this.parcelaDAO.remove(parcela);
        result.forwardTo(this).lista();
    }

    @Get("/parcela")
    public List<Parcela> lista() {
        List<Parcela> m = this.parcelaDAO.listAll();
        return m;
    }
}
