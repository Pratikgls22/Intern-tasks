package com.dao;

import com.model.Info;
import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InfoDao {

    @Autowired
    SessionFactory sessionFactory;

    public void insert(Info info) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(info);
        transaction.commit();
        session.close();
    }

    public List<Info> search(){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Info");
        List<Info> infoList = query.list();
        return infoList;
    }

    public void delete(Info info) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(info);
        transaction.commit();
        session.close();
    }
}