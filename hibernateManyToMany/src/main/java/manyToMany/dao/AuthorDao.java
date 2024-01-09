package manyToMany.dao;

import manyToMany.vo.AuthorVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AuthorDao {
    public void save(AuthorVo authorVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(authorVo);
        transaction.commit();
        session.close();
    }

    public List search() {
        List <AuthorVo> dataList = new ArrayList();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from AuthorVo");
        dataList = query.list();
        session.close();
        return dataList;
    }

    public List<AuthorVo> edit(AuthorVo authorVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from AuthorVo where id = '"+authorVo.getId()+"'");
        List<AuthorVo> list = query.list();
        return list;
    }

    public void update(AuthorVo authorVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(authorVo);
        transaction.commit();
        session.close();
        System.out.println("Data Updated !!");
    }
}
