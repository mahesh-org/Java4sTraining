package org.mahesh.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by maheshwar on 5/31/2015.
 */
@Embeddable
public class Address {
    @Column(name = "ADDRESS_STREE")
    private String street;
    @Column(name = "ADDRESS_CITY")
    private String city;
    @Column(name = "ADDRESS_STATE")
    private String state;
    @Column(name = "ADDRESS_PINCODE")
    private String pincode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String steet) {
        this.street = steet;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "com.embedded.Address{" +
                "steet='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
