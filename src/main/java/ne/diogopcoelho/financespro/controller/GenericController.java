/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ne.diogopcoelho.financespro.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
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
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        String url = "../jsp/" + this.clazz.getSimpleName().toLowerCase() + "/" + req.getPathInfo() + ".jsp";
        req.setAttribute("metodo", req.getPathInfo());
        req.setAttribute("target","listar");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<T> lista = this.dao.listAll();
        req.setAttribute("lista", lista);
        req.getRequestDispatcher((String)req.getAttribute("target"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
