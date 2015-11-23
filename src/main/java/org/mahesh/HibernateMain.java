package org.mahesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.bean.User;

/**
 * Created by Maheshwar Muttal on 10/14/2015.
 */
public class HibernateMain {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        final User user = (User) session.get(User.class, 1);

        System.out.println(user.toString());

        session.close();

    }
}
