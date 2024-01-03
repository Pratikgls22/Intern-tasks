package oneToOne.dao;

import oneToOne.vo.LoginVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class LoginDao {

    public void save(LoginVo loginVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(loginVo);
        transaction.commit();
        session.close();
    }
    public List search() {
        List serachList =  new ArrayList();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from LoginVo");
        serachList = query.list();
        session.close();
        return serachList;
    }
}
