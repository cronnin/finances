/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ne.diogopcoelho.financespro.core;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author diogo.coelho
 */
@RequestScoped
public class SessionCreator implements Serializable {

    @Inject
    private SessionFactory sessionFactory;

    @Produces @RequestScoped
    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void close(@Disposes Session session) {
        if (session.isOpen()) {
            session.close();
        }
    }
}