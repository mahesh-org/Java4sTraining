package org.mahesh.bean;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Created by maheshwar on 5/30/2015.
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "USER_NAME")
    private String userName;
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    @Embedded
    private Address homeAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "street", column = @Column(name = "OFFICE_STREET_NAME")
            ),
            @AttributeOverride(
                    name = "city", column = @Column(name = "OFFICE_CITY_NAME")
            ),
            @AttributeOverride(
                    name = "state", column = @Column(name = "OFFICE_STATE_NAME")
            ),
            @AttributeOverride(
                    name = "pincode", column = @Column(name = "OFFICE_PINCODE_NAME")
            ),
    })
    private Address officeAddress;
    @Lob
    private String description;
    @Transient
    private String columnSkip;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName + " from getter";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColumnSkip() {
        return columnSkip;
    }

    public void setColumnSkip(String columnSkip) {
        this.columnSkip = columnSkip;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address address) {
        this.homeAddress = address;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Override
    public String toString() {
        return "com.embedded.UserDetails{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", joinedDate=" + joinedDate +
                ", homeAddress='" + homeAddress + '\'' +
                ", officeAddress='" + officeAddress + '\'' +
                ", description='" + description + '\'' +
                ", columnSkip='" + columnSkip + '\'' +
                '}';
    }
}

