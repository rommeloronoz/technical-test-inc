package com.rommel.technicaltestinc.models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private int accountId;
    @Column(name = "email")
    private String email;
    @Column(name = "birthdate")
    private java.sql.Date birthDate;
    @Column(name = "last_payment_date")
    private java.sql.Timestamp lastPaymentDate;
    @Column(name = "created_on")
    private Timestamp createdOn;

    public Account () {}

    public Account (int accountId, String email, Date birthDate, Timestamp lastPaymentDate, Timestamp createdOn) {
        this.accountId = accountId;
        this.email = email;
        this.birthDate = birthDate;
        this.lastPaymentDate = lastPaymentDate;
        this.createdOn = createdOn;
    }

    public int getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Date return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return String return the lastPaymentDate
     */
    public Timestamp getLastPaymentDate() {
        return lastPaymentDate;
    }

    /**
     * @param lastPaymentDate the lastPaymentDate to set
     */
    public void setLastPaymentDate(Timestamp lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }


    /**
     * @return Timestamp return the createdAt
     */
    public Timestamp getCreatedAt() {
        return createdOn;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdOn = createdAt;
    }

}
