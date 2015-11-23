package org.mahesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mahesh.bean.Product;

/**
 * Created by Maheshwar Muttal on 10/19/2015.
 */
public class HibernateMain {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session1 = sessionFactory.openSession();

        Product product = null;          //Transient state..
        Object o = session1.get(Product.class, new Integer(1));
        product = (Product) o;           //now p is in Persistent state..

        session1.close();

        product.setProductName("Product LifeCycleOfPojoClass");
        product.setPrice(36000);         // p is in Detached state

        Session session2 = sessionFactory.openSession();

        Transaction transaction = session2.beginTransaction();
        session2.update(product);      // now p reached to Persistent state
        transaction.commit();
    }
}
