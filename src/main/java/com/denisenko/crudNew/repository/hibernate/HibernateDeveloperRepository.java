package com.denisenko.crudNew.repository.hibernate;

import com.denisenko.crudNew.model.Developer;
import com.denisenko.crudNew.repository.DeveloperRepository;
import com.denisenko.crudNew.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateDeveloperRepository implements DeveloperRepository {
    @Override
    public Developer getById(Long aLong) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Developer.class, aLong);
    }

    @Override
    public Developer save(Developer developer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        session.save(developer);
        transaction.commit();
        session.close();
        return getById(developer.getId());
    }

    @Override
    public boolean deleteById(Long aLong) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete Developer where id = :ID");
        query.setParameter("ID", aLong);
        boolean res = query.executeUpdate() > 0;
        transaction.commit();
        session.close();
        return res;
    }

    @Override
    public List<Developer> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Developer> developerList = session.createQuery("select d from Developer d",Developer.class).getResultList();
        return developerList;
    }

    @Override
    public Developer update(Developer developer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        session.update(developer);
        transaction.commit();
        session.close();
        return getById(developer.getId());
    }
}
