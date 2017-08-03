package org.mahesh;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.mahesh.bean.Product;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Maheshwar Muttal on 10/14/2015.
 * Projection mainly helps in loading the partial object while working with Criteria. This concept is introduced in Hibernate 3.0.
 * Two main operations can be done using the project.
 *   1) Can load the partial object from the database
 *   2) Can find the result of Aggregation functions
 * Projection in an Interface and Projections is a Class for producing the projection objects.
 * In order to add Projection to a Criteria, we need to call a method -- setProjection().
 * Remember, we can add only one Projection at a time. Incase if we add, it will override with 2nd one.
 *
 * IMPORTANT : Without Projection we cant not select the partial object from the database
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

        /* 1) Criteria using Projection Start*/
        Criteria criteria = session.createCriteria(Product.class);
        criteria.setProjection(Projections.property("price"));

        List list = criteria.list();
        System.out.println("Product size: " + list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("**************1111*************");
        /* Criteria using Projection End*/

        /* 2) Criteria using multiple Projection (Ignores other Projections) Start*/
        criteria = session.createCriteria(Product.class);
        criteria.setProjection(Projections.property("price")); /* IMPORTANT */
        criteria.setProjection(Projections.property("productName"));

        list = criteria.list();
        System.out.println("Product size: " + list.size());
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("**************2222*************");
        /* 2) Criteria using multiple Projection (Ignores other Projections) End*/

        /* 3) Criteria using multiple Projection using ProjectionList Start*/
        criteria = session.createCriteria(Product.class);

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("productName"));
        projectionList.add(Projections.property("price"));
        criteria.setProjection(projectionList);

        list = criteria.list();
        System.out.println("Product size: " + list.size());
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj[] = (Object[]) iterator.next();
            System.out.println(obj[0] + " : " + obj[1]);
        }
        System.out.println("**************2222*************");
        /* 3) Criteria using multiple Projection using ProjectionList End*/

        /* 4) Criteria using Projection count distinct Start*/
        criteria = session.createCriteria(Product.class);
        criteria.setProjection(Projections.countDistinct("productName"));

        List countlist = criteria.list();
        System.out.println("Product size: " + list.size());
        Iterator iteratorCount = list.iterator();
        while (iteratorCount.hasNext()) {
            System.out.println(iteratorCount.next());
        }
        System.out.println("**************4444444*************");
        /* 4) Criteria using Projection count distinct End*/

        session.close();
        sessionFactory.close();
    }

    private final static Product createProduct(int unit) {
        Product product = new Product();
        //product.setProductName("Criteria Query Product " + unit);
        product.setProductName("mahi");
        product.setPrice(100);

        return product;
    }
}
