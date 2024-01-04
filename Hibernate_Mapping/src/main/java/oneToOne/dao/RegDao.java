package oneToOne.dao;

import oneToOne.vo.RegVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RegDao {

    public void save(RegVo regVo){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(regVo);
        transaction.commit();
        session.close();
    }

    public List search() {
        List serachList =  new ArrayList();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from RegVo");
        serachList = query.list();
        session.close();
        return serachList;
    }

    public void delete(RegVo regVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(regVo);
        transaction.commit();
        session.close();
    }

    public List<RegVo> findById(RegVo regVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM  RegVo where id='"+regVo.getId()+"'");
        List<RegVo> findId = query.list();
        return findId;
    }

    public List<RegVo> edit(RegVo regVo) {
        List<RegVo> regVoList =new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from RegVo where id = '"+regVo.getId()+"'");
        regVoList = query.list();
        transaction.commit();
        session.close();
        return regVoList;
    }

    public void update(RegVo regVo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(regVo);
        transaction.commit();
        session.close();
    }
}
