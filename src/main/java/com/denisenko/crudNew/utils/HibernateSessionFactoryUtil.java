package com.denisenko.crudNew.utils;

import com.denisenko.crudNew.model.Developer;
import com.denisenko.crudNew.model.Skill;
import com.denisenko.crudNew.model.Team;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {};

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try{
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Developer.class);
                configuration.addAnnotatedClass(Skill.class);
                configuration.addAnnotatedClass(Team.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                                                            .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
