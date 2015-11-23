package org.mahesh;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.mahesh.bean.Product;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by Maheshwar Muttal on 10/28/2015.
 * Native SQL is another technique of performing bulk operations on the data using hibernate.
 * By using Native SQL, we can perform both select, non-select operations on the data
 * Advantages : We can use the database specific keywords to get the data from database. Migrating JDBC program into Hibernate tasks becomes very easy.
 * To execute Native SQL Queries on the database then, we need to construct an object of SQLQuery, actually this SQLQuery is an interface extended from Query
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

        /* 1) Execute Native SQL Queries Start*/
        SQLQuery sqlQuery = session.createSQLQuery("select * from products");
        List list = sqlQuery.list();
        System.out.println("Product size: " + list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object[] objects = (Object[]) iterator.next();
            System.out.println(objects[0] + ", " + objects[1]  + ", " + objects[2]);
        }
        System.out.println("**************1111*************");
        /* Execute Native SQL Queries End */

        /* 2) Execute Native SQL Queries and types cast to Object using Entity Query Start*/
        sqlQuery = session.createSQLQuery("select * from products").addEntity(Product.class);
        list = sqlQuery.list();
        System.out.println("Product size: " + list.size());
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            System.out.println(product.toString());
        }
        System.out.println("**************2222*************");
        /* Execute Native SQL Queries and types cast to Object using Entity Query End*/

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
