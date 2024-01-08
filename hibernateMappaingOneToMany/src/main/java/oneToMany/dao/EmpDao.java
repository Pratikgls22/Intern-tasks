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
    public static List<EmpVo> findById(EmpVo empVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from EmpVo where id = '" + empVo.getId() + "'");
        List<EmpVo> findId = query.list();
        return findId;
    }

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

    public void delete(EmpVo empVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(empVo);
        transaction.commit();
        session.close();
    }



    public List<EmpVo> edit(EmpVo empVo) {
        List<EmpVo> empEdit = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from EmpVo where id = '"+empVo.getId()+"'");
        empEdit = query.list();
        transaction.commit();
        session.close();
        return empEdit;
    }

    public void update(EmpVo empVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(empVo);
        transaction.commit();
        session.close();
    }
}
