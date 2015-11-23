package org.mahesh.bean;

import javax.persistence.*;

/**
 * Created by Maheshwar Muttal on 10/14/2015.
 */
@Entity
@Table(name = "PRODUCTS")
@NamedQueries({
        @NamedQuery(name = "@all", query = "from Product p"),
        @NamedQuery(name = "byProductId", query = "from Product p where p.productId=:productId")
})
/* Not working */
/*@NamedNativeQueries({
        @NamedNativeQuery(name="all123", query = "select * from products")
})*/
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
