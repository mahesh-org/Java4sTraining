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
        final Product product = (Product)session.get(Product.class, 1);
        System.out.println(product);
        session.delete(product);
        session.getTransaction().commit();

        System.out.println(product.getProductId() + " deleted.....");
        session.close();
    }

    private final static Product createProduct() {
        Product product = new Product();
        product.setProductName("Product 1");
        product.setPrice(100);
        return product;
    }
}
