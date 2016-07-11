/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import java.io.Serializable;
import java.util.List;
import net.diogopcoelho.finances.dao.GenericDAO;

/**
 *
 * @author diogo.coelho
 * @param <T>
 * @param <Pk>
 */
public abstract class GenericController<T extends Serializable, Pk extends Serializable> {
    
    protected GenericDAO<T,Pk> dao;
    protected Validator validator;
    protected Result result;

    @Deprecated
    public GenericController() {
    }

    public GenericController(GenericDAO<T, Pk> dao, Validator validator, Result result) {
        this.dao = dao;
        this.validator = validator;
        this.result = result;
    }
    
    @Get("/novo")
    public void formulario() {
        result.include("lista", this.dao.listAll());
    }

    @Get("/{id}")
    public T formulario(Pk id) {
        validator.onErrorUsePageOf(this).lista();
        result.include("lista", this.dao.listAll());
        return this.dao.find(id);
    }

    @Put("/")
    public void altera(T registro) {
        validator.onErrorUsePageOf(this).lista();
        validar(registro);
        this.dao.update(registro);
        result.forwardTo(this).lista();
    }

    @Post("/")
    public void adiciona(final T registro) {
        validator.onErrorUsePageOf(this).lista();
        validar(registro);
        this.dao.add(registro);
        result.forwardTo(this).lista();
    }

    @Delete("/{id}")
    public void remove(Pk id) {
        validator.onErrorUsePageOf(this).lista();
        T registro = this.dao.find(id);
        this.dao.remove(registro);
        result.forwardTo(this).lista();
    }

    @Get("/")
    public List<T> lista() {
        List<T> registro = this.dao.listAll();
        return registro;
    }

    public abstract void validar(T registro);
    
}
