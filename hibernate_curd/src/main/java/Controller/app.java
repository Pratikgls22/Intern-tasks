package Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class app {
    public static void main(String[] args) {
        System.out.println("Hello !!");

//        Configuration cfg = new Configuration();
//        cfg.configure();
//
//        SessionFactory factory = cfg.buildSessionFactory();
//        System.out.println(factory);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
    }
}
