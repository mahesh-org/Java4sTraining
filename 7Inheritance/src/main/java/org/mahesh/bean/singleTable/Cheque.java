package org.mahesh.bean.singleTable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Maheshwar Muttal on 10/20/2015.
 */
@Entity
@DiscriminatorValue(value = "CH")
public class Cheque extends Payment {
    @Column(name = "CH_TYPE")
    private String cType;

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    @Override
    public String toString() {
        return "Cheque{" +
                "cType='" + cType + '\'' +
                '}';
    }
}
