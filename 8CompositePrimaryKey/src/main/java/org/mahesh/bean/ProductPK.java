package org.mahesh.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Maheshwar Muttal on 10/21/2015.
 */
@Embeddable
public class ProductPK implements Serializable {

    @Column(name = "PRODUCT_ID")
    private int productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    public ProductPK() {
    }

    public ProductPK(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductPK productPK = (ProductPK) o;

        if (getProductId() != productPK.getProductId()) return false;
        return getProductName().equals(productPK.getProductName());

    }

    @Override
    public int hashCode() {
        int result = getProductId();
        result = 31 * result + getProductName().hashCode();
        return result;
    }
}
