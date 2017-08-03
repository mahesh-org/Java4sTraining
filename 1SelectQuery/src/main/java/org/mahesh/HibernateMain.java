package org.mahesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.bean.Product;

/**
 * Created by Maheshwar Muttal on 10/14/2015.
 */
public class HibernateMain {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Product productCopy = null;

        Product product = createProduct();
        session.save(product);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        product = (Product)session.get(Product.class, 1);
        productCopy = product;
        product.setPrice(200);
        //session.getTransaction().commit();
        /*session.close();
        System.out.println(product);

        session = sessionFactory.openSession();
        session.beginTransaction();*/
        //productCopy.setPrice(500);
        //session.update(productCopy);
        System.out.println(productCopy);
        session.getTransaction().commit();
        session.close();

    }

    private final static Product createProduct() {
        Product product = new Product();
        product.setProductName("Product 1");
        product.setPrice(100);
        return product;
    }
}
