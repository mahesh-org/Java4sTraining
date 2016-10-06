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
 * HQL is very similar to SQL except that we use Objects instead of table names, that makes more close to Object oriented programming.
 * Disadvantage : We need to take care of table mappings in our code.
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
        /*1) Selecting all/complete objects(records) start*/
        Query query1 = session.createQuery("select p from Product p");
        List list1 = query1.list();

        System.out.println("Total number of records: "+ list1.size());
        Iterator iterator1 = list1.iterator();
        while (iterator1.hasNext()) {
            Object o = iterator1.next();

            product = (Product) o;
            System.out.println(product.toString());
        }
        System.out.println("*************11111*****************");
        /*Selecting all/complete objects(records) End */

        /*2) Selecting partial objects(records) Start */
        Query query2 = session.createQuery("select p.productName, p.price from Product p");
        List list2 = query2.list();

        System.out.println("Total number of records: "+ list2.size());
        Iterator iterator2 = list2.iterator();
        while (iterator2.hasNext()) {
            Object o[] = (Object[]) iterator2.next();

            System.out.println("Product ID: "+o[0] + " Name: "+o[1]);
        }
        System.out.println("**************22222****************");
        /*Selecting partial objects(records) End */

        /*3) Using label :java4s start - Passing Runtime values*/
        Query query3 = session.createQuery("select p from Product p where p.productId=:java4s");
        query3.setParameter("java4s", 1);

        List list3 = query3.list();
        System.out.println("Total Number Of Records : "+list3.size());
        Iterator iterator3 = list3.iterator();
        while (iterator3.hasNext()) {
            product = (Product) iterator3.next();
            System.out.println(product);
        }
        System.out.println("**************3333****************");
        /*Using label :java4s End*/

        /*4) Using Question mark ? Start - Passing Runtime values*/
        Query query4 = session.createQuery("from Product p where p.productId=?");
        query4.setParameter(0, 2);

        List list4 = query4.list();
        System.out.println("Total Number Of Records : "+list4.size());
        Iterator iterator4 = list4.iterator();
        while (iterator4.hasNext()) {
            product = (Product) iterator4.next();
            System.out.println(product);
        }
        System.out.println("**************4444****************");
        /*Using Question mark ? End*/

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
