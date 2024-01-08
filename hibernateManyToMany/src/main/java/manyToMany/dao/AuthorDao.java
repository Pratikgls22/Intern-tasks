package manyToMany.dao;

import manyToMany.vo.AuthorVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AuthorDao {
    public void save(AuthorVo authorVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(authorVo);
        transaction.commit();
        session.close();
    }
}
