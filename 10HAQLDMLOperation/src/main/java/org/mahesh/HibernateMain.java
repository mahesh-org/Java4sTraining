package org.mahesh;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.bean.Product;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Maheshwar Muttal on 10/14/2015.
 */
public class HibernateMain {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Product product1 = createProduct(1);
        Product product2 = createProduct(2);
        session.save(product1);
        session.save(product2);
        session.getTransaction().commit();

        Product product;
        session.beginTransaction();

        /*5) Deleting a record - Use executeQuery() for DML operation*/
        Query query5 = session.createQuery("delete from Product p where p.productId=:java4s");
        query5.setParameter("java4s", 1);

        int result  = query5.executeUpdate();
        System.out.println("Numer of records effected due to delete query" + result);

        query5 = session.createQuery("select p from Product p");
        List list5 = query5.list();

        System.out.println("Total number of records: "+ list5.size());
        Iterator iterator5 = list5.iterator();
        while (iterator5.hasNext()) {
            Object o = iterator5.next();

            product = (Product) o;
            System.out.println(product.toString());
        }

        System.out.println("**************5555****************");
        /*Deleting a record End*/

        /*6) Updating a record - Use executeQuery() for DML operation*/
        Query query6 = session.createQuery("update Product p set productName=:PName, price=:PPrice where p.productId=:java4s");
        query6.setParameter("java4s", 2);
        query6.setParameter("PName", "Updated Product Name..");
        query6.setParameter("PPrice", 20000.00);

        int result6  = query6.executeUpdate();
        System.out.println("Numer of records effected due to Update query" + result);

        query6 = session.createQuery("select p from Product p");
        List list6 = query6.list();

        System.out.println("Total number of records: "+ list6.size());
        Iterator iterator6 = list6.iterator();
        while (iterator6.hasNext()) {
            Object o = iterator6.next();

            product = (Product) o;
            System.out.println(product.toString());
        }

        System.out.println("*************6666****************");
        /*Updating a record End*/

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    private final static Product createProduct(int unit) {
        Product product = new Product();
        product.setProductName("HQL Product " + unit);
        product.setPrice(100 + unit);

        return product;
    }
}
