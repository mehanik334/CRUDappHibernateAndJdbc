package com.denisenko.crudNew.repository.hibernate;

import com.denisenko.crudNew.model.Skill;
import com.denisenko.crudNew.repository.SkillRepository;
import com.denisenko.crudNew.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateSkillRepository implements SkillRepository {


    @Override
    public Skill getById(Long aLong) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Skill.class, aLong);
    }

    @Override
    public Skill save(Skill skill) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(skill);
        transaction.commit();
        session.close();
        return getById(skill.getId());
    }

    @Override
    public boolean deleteById(Long aLong) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete Skill where id = :ID");
        query.setParameter("ID", aLong);
        boolean res = (query.executeUpdate() > 0);
        transaction.commit();
        session.close();
        return res;
    }

    @Override
    public List<Skill> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Skill> skills = session.createQuery("select s from Skill s", Skill.class).getResultList();
        return skills;
    }

    @Override
    public Skill update(Skill skill) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(skill);
        transaction.commit();
        session.close();
        return getById(skill.getId());
    }
}
