package org.mahesh.bean.singleTable;

import javax.persistence.*;

/**
 * Created by Maheshwar Muttal on 10/20/2015.
 */
@Entity
@Table(name = "PAYMENT")
@DiscriminatorColumn (name = "PAYMENT_YPE", discriminatorType = DiscriminatorType.STRING)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int paymentId;
    private double amount;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", amount=" + amount +
                '}';
    }
}
