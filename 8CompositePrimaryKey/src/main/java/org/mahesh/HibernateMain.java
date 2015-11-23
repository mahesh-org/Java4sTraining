package org.mahesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.bean.Product;
import org.mahesh.bean.ProductPK;

/**
 * Created by Maheshwar Muttal on 10/21/2015.
 */
public class HibernateMain {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ProductPK productPK = createProductPK(100, "Product 1");
        Product product = createProduct(productPK);

        final ProductPK productPK2 = createProductPK(200, "Product 1");
        Product product2 = createProduct(productPK2);

        session.save(product);
        session.getTransaction().commit();
        session.beginTransaction();
        session.save(product2);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        product = (Product)session.get(Product.class, 100);
        System.out.println(product);
    }

    private final static ProductPK createProductPK(final int id, final String name) {
        ProductPK productPK = new ProductPK(id, name);

        return productPK;
    }

    private final static Product createProduct(final ProductPK productPK) {
        Product product = new Product();
        product.setProductPK(productPK);
        product.setPrice(100);

        return product;
    }
}
