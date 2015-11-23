package org.mahesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mahesh.bean.tablePerSubClass_Joined.Cheque;
import org.mahesh.bean.tablePerSubClass_Joined.CreditCard;
import org.mahesh.bean.tablePerSubClass_Joined.Payment;

/**
 * Created by Maheshwar Muttal on 10/20/2015.
 */
public class HibernateMain {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Payment payment = createPayment();
        session.save(payment);

        CreditCard creditCard = createCreditCard();
        session.save(creditCard);

        Cheque cheque = createCheque();
        session.save(cheque);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

    private static Cheque createCheque() {
        Cheque cheque = new Cheque();
        cheque.setcType("ICICI");
        cheque.setAmount(300);

        return cheque;
    }

    private static CreditCard createCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setCcType("VISA");
        creditCard.setAmount(200);

        return creditCard;
    }

    private static Payment createPayment() {
      Payment payment = new Payment();
        payment.setAmount(100);

        return payment;
    }

}
