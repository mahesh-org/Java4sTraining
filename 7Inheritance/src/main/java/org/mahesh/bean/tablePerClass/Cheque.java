package org.mahesh.bean.tablePerClass;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Maheshwar Muttal on 10/20/2015.
 */
@Entity
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
