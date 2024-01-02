package com.Dao;

import com.model.RegVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RegDao {
    @Autowired
    SessionFactory sessionFactory;

    public void insert(RegVo regVo) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(regVo);
        transaction.commit();
        session.close();
    }

    public List search() {
        List list ;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from RegVo");

        list = query.list();
        return list;
    }

    public void delete(RegVo regVo) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(regVo);
        transaction.commit();
        session.close();
    }

    public List<RegVo> edit(RegVo regVo) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from RegVo where id='"+regVo.getId()+"'");
        List editList = query.list();
        return editList;
    }
}
