/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ne.diogopcoelho.financespro.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ne.diogopcoelho.financespro.dao.GenericDAO;

/**
 *
 * @author diogo.coelho
 * @param <T>
 * @param <Pk>
 */
public abstract class GenericController<T extends Serializable,Pk extends Serializable> extends HttpServlet {
    private Class clazz;
    private GenericDAO dao;

    @Deprecated
    public GenericController() {
    }
    
    public GenericController(Class clazz, GenericDAO dao) {
        this.clazz = clazz;
        this.dao = dao;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        
        String url = "";
        if("/novo".equals(req.getPathInfo())) {
            url = novo();
        }else {
            url = lista(req);
        }
        
        url = finPath(url, req);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    protected String finPath(String deafultPath, HttpServletRequest req){
        
        String defaultPath = req.getPathInfo();
        if(defaultPath==null)
            defaultPath = deafultPath;
        
        return "/WEB-INF/jsp/" + this.clazz.getSimpleName().toLowerCase() + defaultPath + ".jsp";
        
    }

    protected String novo() {
        return "/novo";
    }

    protected String lista(HttpServletRequest req) {
        List<T> lista = this.dao.listAll();
        req.setAttribute("lista", lista);
        return "/lista";
    }
    
}
