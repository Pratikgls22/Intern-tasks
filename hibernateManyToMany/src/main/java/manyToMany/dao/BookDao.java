package manyToMany.dao;

import manyToMany.vo.BookVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public void save(BookVo bookVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bookVo);
        transaction.commit();
    }

    public List search() {
        List <BookVo> dataList = new ArrayList();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from BookVo");
        dataList=query.list();
        session.close();
        return dataList;
    }
}
