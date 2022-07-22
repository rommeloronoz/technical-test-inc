package com.rommel.technicaltestinc.models;

import com.google.gson.annotations.SerializedName;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Error {
    @SerializedName("payment_id")
    private String paymentId;
    @SerializedName("error")
    @Enumerated(EnumType.STRING)
    private ErrorType errorType;
    @SerializedName("error_description")
    private String errorDescription;


    public Error () {}

    public Error (String paymentId, ErrorType errorType, String errorDescription) {
        this.paymentId = paymentId;
        this.errorType = errorType;
        this.errorDescription = errorDescription;
    }

    /**
     * @return String return the paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * @return ErrorType return the errorType
     */
    public ErrorType getErrorType() {
        return errorType;
    }


    public void setErrorType(String et) {
        switch (et) {
            case "database":
            errorType = ErrorType.database;
            break;

            case "network":
            errorType = ErrorType.network;
            break;

            default:
            errorType = ErrorType.other;
            break;

        }

    }

    /**
     * @return String return the errorDescription
     */
    public String getErrorDescription() {
        return errorDescription;
    }

    /**
     * @param errorDescription the errorDescription to set
     */
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

}
