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


        Product product = createProduct();
        session.save(product);
        session.getTransaction().commit();
        session.close();

        /**** First Approach with the use of session.Update() ***
        session = sessionFactory.openSession();
        product = (Product)session.get(Product.class, 1);
        System.out.println(product);

        session.beginTransaction();
        product.setProductName("Product name Altered with session.Update()...");
        //session.update(product);
        session.getTransaction().commit();
        session.close();
        ** End of First Approach ***/

        /** Second Approach without the use of session.Update()***/
        session = sessionFactory.openSession();
        session.beginTransaction();
        product = (Product) session.load(Product.class, 1);
        product.setProductName("Updated without session.Update()...");
         //Even though session.update() not called explicitly , commit() will internally calls the update() method
        session.getTransaction().commit();

        /** End of Second Approach ***/


        session = sessionFactory.openSession();
        product = (Product)session.get(Product.class, 1);
        System.out.println(product);
        session.close();

    }

    private final static Product createProduct() {
        Product product = new Product();
        product.setProductName("Product 1");
        product.setPrice(100);
        return product;
    }
}
