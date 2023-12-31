package oneToMany.dao;

import oneToMany.vo.CompanyVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CompanyDao {
    public void save(CompanyVo companyVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(companyVo);
        transaction.commit();
        session.close();
    }

    public void delete(CompanyVo companyVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(companyVo);
        transaction.commit();
        session.close();
    }

    public void update(CompanyVo companyVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(companyVo);
        transaction.commit();
        session.close();
    }

}
