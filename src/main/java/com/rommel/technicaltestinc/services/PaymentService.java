package com.rommel.technicaltestinc.services;

import com.rommel.technicaltestinc.exceptions.CustomDBException;
import com.rommel.technicaltestinc.exceptions.CustomNetworkException;
import com.rommel.technicaltestinc.models.ErrorType;
import com.rommel.technicaltestinc.models.Payment;
import com.rommel.technicaltestinc.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.rommel.technicaltestinc.models.Error;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    private ApiService apiService;
    private HttpStatus httpStatus;
    @Autowired
    private AccountService accountService;


    public PaymentService (PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
        apiService = new ApiService(new RestTemplate());
    }

    @Transactional
    public void createPayment (Payment payment, boolean validate) {
        try {
            checkPaymentFormat(payment);

            if (validate) {
                httpStatus = apiService.validatePayment(payment);
                if (httpStatus  != HttpStatus.OK) {throw new CustomNetworkException("Network exception. HttpCode: " + httpStatus);}
            }

            try {
                paymentRepository.save(payment);
                accountService.updateLastPaymentDateById(payment.getCreatedOn(), payment.getAccountId());
            } catch (Exception e) {
                throw new CustomDBException(e.getMessage());
            }

        } catch (CustomDBException exception) {
            apiService.sendLog(new Error(payment.getPaymentId(), ErrorType.database, exception.getMessage()));

        }
        catch (CustomNetworkException exception) {
            apiService.sendLog(new Error(payment.getPaymentId(), ErrorType.network, exception.getMessage()));

        } catch (Exception exception) {
            apiService.sendLog(new Error(payment.getPaymentId(), ErrorType.other, exception.getMessage()));
        }
    }

    private void checkPaymentFormat (Payment payment) throws Exception {
        if (payment.getPaymentId() == null || payment.getPaymentId() == "") {throw new Exception("Invalid payment id");}
        if (payment.getAccountId() == 0) {throw new Exception("Invalid account id");}
        if (payment.getPaymentType() == null) {throw new Exception("Invalid payment type");}
        if (payment.getAmount() == 0) {throw new Exception("Invalid amount");}
        if (payment.getCreditCard() == null || payment.getCreditCard() == "") {throw new Exception("Invalid credit card");}
    }
}
