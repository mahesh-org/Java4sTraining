package org.mahesh;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.mahesh.bean.Product;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Maheshwar Muttal on 10/14/2015.
 * Criteria mainly works for loading the complete object from the database.
 * We cant not run Criteria to run update or delete queries or any DDL statements. Its been only used to fetch the data.
 */
public class HibernateMain {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Product product1 = createProduct(1);
        Product product2 = createProduct(2);
        Product product3 = createProduct(3);
        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.getTransaction().commit();

        /* 1) Criteria using Criterion Interface and Restrictions Class */
        Criteria criteria = session.createCriteria(Product.class);
        Criterion criterion = Restrictions.gt("price", new Double(101));
        criteria.add(criterion);

        List list = criteria.list();
        System.out.println("Product size: " + list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            System.out.println(product.toString());
        }
        System.out.println("**************1111*************");
        /* Criteria using Criterion Interface and Restrictions Class End*/

        /* 2) Adding Conditions to Criteria start*/
        criteria = session.createCriteria(Product.class);
        criterion = Restrictions.gt("price", new Double(101));
        criteria.add(criterion);
        criteria.addOrder(Order.desc("price"));

        list = criteria.list();
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            System.out.println(product.toString());
        }
        System.out.println("**************2222*************");
        /* Adding Conditions to Criteria End */

        session.close();

    }

    private final static Product createProduct(int unit) {
        Product product = new Product();
        product.setProductName("Criteria Query Product " + unit);
        product.setPrice(100 + unit);

        return product;
    }
}
