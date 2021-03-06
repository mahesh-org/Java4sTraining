package org.mahesh.bean.singleTable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Maheshwar Muttal on 10/20/2015.
 */
@Entity
@DiscriminatorValue(value = "CC")
public class CreditCard extends Payment {

    @Column(name = "CC_TYPE")
    private String ccType;

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "ccType='" + ccType + '\'' +
                '}';
    }
}
