package oneToMany.dao;

import oneToMany.vo.EmpVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class EmpDao {
    public void save(EmpVo empVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(empVo);
        transaction.commit();
        session.close();
    }

    public List search() {
        List serachList =  new ArrayList();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from EmpVo");
        serachList = query.list();
        session.close();
        return serachList;
    }
}
