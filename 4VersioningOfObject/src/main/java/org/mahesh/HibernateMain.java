package org.mahesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.bean.Product;

/**
 * Created by Maheshwar Muttal on 10/16/2015.
 */
public class HibernateMain {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Product product = createProduct();
        session.save(product);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        product = (Product) session.load(Product.class, 1);
        product.setProductName("Updated Product");
        session.getTransaction().commit();

        session = sessionFactory.openSession();
        product = (Product)session.get(Product.class, 1);
        System.out.println(product);
        session.close();

        // Note: If the version column is NULL then update will through NPE, it should be >=0
    }

    private final static Product createProduct() {
        Product product = new Product();
        product.setProductName("Product VersioningOfObject");
        product.setPrice(100);
        return product;
    }
}