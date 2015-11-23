package org.mahesh.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Maheshwar Muttal on 10/21/2015.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @EmbeddedId
    private ProductPK productPK;

    @Column(name = "PRICE")
    private double price;

    public ProductPK getProductPK() {
        return productPK;
    }

    public void setProductPK(ProductPK productPK) {
        this.productPK = productPK;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productPK=" + productPK.toString() +
                ", price=" + price +
                '}';
    }
}
