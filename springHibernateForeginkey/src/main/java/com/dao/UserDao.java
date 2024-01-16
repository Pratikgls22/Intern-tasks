package com.dao;

import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    SessionFactory sessionFactory;

    public void insert(User user){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    public List<User> search() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User");
        List<User> list = query.list();
        return list;
    }

    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public List<User> findById(User user) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User where id='"+user.getUserId()+"'");
        List<User> userList = query.list();
        return userList;
    }
}
