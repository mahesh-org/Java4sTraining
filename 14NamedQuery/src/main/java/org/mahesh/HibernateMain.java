package org.mahesh;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.bean.Product;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Maheshwar Muttal on 10/28/2015.
 * Named query can be useful when same query needs to be executed in multiple places.
 * This is mainly bcs the queries can be kept it in the class. Its just avoids messing up all the queries in different classes.
 * Its like a Central location, will keep all quires with it, use them any where.
 *
 * Two annotations mainly : @NamedQuery and @NamedNativeQuery
 * In case of xml : 'query' element/tag is used for HQL, named queries and 'sql-query' element is used for native sql named queries.
 *
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

        /* 1) Named Query and Native Query with annotation Start*/
        //Query query = session.getNamedQuery("@all");
        Query query = session.getNamedQuery("byProductId");
        query.setParameter("productId", 3);
        List list = query.list();
        System.out.println("Product size: " + list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            System.out.println(product.toString());
        }
        System.out.println("**************1111*************");
        /* Named Query and Native Query with annotation End */

        session.close();
        sessionFactory.close();
    }

    private final static Product createProduct(int unit) {
        Product product = new Product();
        product.setProductName("Criteria Query Product " + unit);
        product.setPrice(100 + unit);

        return product;
    }
}
