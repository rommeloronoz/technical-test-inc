package com.rommel.technicaltestinc.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @JsonProperty("payment_id")
    @SerializedName("payment_id")
    private String paymentId;
    @JsonProperty("account_id")
    @SerializedName("account_id")
    @Column(name = "account_id")
    private int accountId;
    @JsonProperty("payment_type")
    @SerializedName("payment_type")
    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @JsonProperty("credit_card")
    @SerializedName("credit_card")
    @Column(name = "credit_card")
    private String creditCard;
    @Column(name = "amount")
    private int amount;
    @Column(name = "created_on")
    private java.sql.Timestamp createdOn;


    public Payment (String paymentId, int accountId, PaymentType paymentType, String creditCard, int amount) {
        this.paymentId = paymentId;
        this.accountId = accountId;
        this.paymentType = paymentType;
        this.creditCard = creditCard;
        this.amount = amount;

    }

    public String getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public String getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setCreatedOn (Timestamp createdOn) {this.createdOn = createdOn;}
    public Timestamp getCreatedOn () {return createdOn;}

    public void setPaymentType(String pt) {
        if (pt.equals("online")) {
            paymentType =  PaymentType.online;
        } else {
            paymentType =  PaymentType.offline;
        }
    }

    public PaymentType getPaymentType(){
        return paymentType;
    }
    
}
