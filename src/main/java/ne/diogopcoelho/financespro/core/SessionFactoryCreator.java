/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ne.diogopcoelho.financespro.core;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author diogo.coelho
 */
@ApplicationScoped
public class SessionFactoryCreator implements Serializable{

    private SessionFactory sessionFactory;

    public SessionFactoryCreator() {
        
    }

    @Produces @RequestScoped
    public SessionFactory getSessionFacSession() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
		// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            Logger.getLogger(SessionFactoryCreator.class.getName()).log(Level.SEVERE, null, ex);
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return sessionFactory;
    }

    public void close(@Disposes SessionFactory sessionFactory) {
        if (!sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
