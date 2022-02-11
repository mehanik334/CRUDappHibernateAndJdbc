package com.denisenko.crudNew.repository.hibernate;

import com.denisenko.crudNew.model.Team;
import com.denisenko.crudNew.repository.TeamRepository;
import com.denisenko.crudNew.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.List;

public class HibernateTeamRepository implements TeamRepository {
    @Override
    public Team getById(Long aLong) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Team.class,aLong);
    }

    @Override
    public Team save(Team team) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        session.save(team);
        if(transaction.getStatus().equals(TransactionStatus.ACTIVE)) {
            transaction.commit();
        }
        session.close();
        return getById(team.getId());
    }

    @Override
    public boolean deleteById(Long aLong) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete Team where id = :ID");
        query.setParameter("ID",aLong);
        boolean res = (query.executeUpdate() > 0);
        transaction.commit();
        session.close();
        return res;
    }

    @Override
    public List<Team> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Team> teamList = session.createQuery("select t from Team t",Team.class).getResultList();
        return teamList;
    }

    @Override
    public Team update(Team team) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(team);
        transaction.commit();
        session.close();
        return getById(team.getId());
    }
}
