/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Administrator
 */
public class SessionFactoryUtil {

    public static SessionFactory sessionFactory;

    static {
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties()).build();
        cfg.buildSessionFactory(
                serviceRegistry);
        sessionFactory=cfg.buildSessionFactory();

    }

}
