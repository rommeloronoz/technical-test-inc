package com.rommel.technicaltestinc.services;

import com.google.gson.Gson;
import com.rommel.technicaltestinc.models.Error;
import com.rommel.technicaltestinc.models.ErrorType;
import com.rommel.technicaltestinc.models.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.rommel.technicaltestinc.models.Payment;
import org.springframework.web.client.RestTemplate;

@Service
public class KafkaConsumerService {

    private Gson gson = new Gson();
    @Autowired
    private PaymentService paymentService;
    private ApiService apiService = new ApiService(new RestTemplate());

    @KafkaListener(topics = {"online", "offline"}, groupId = "test-consumer-group", containerFactory = "paymentListener")
    public void consumeFromTopic(Payment payment) {

        try {

            if (payment.getPaymentType() == PaymentType.online) {
                paymentService.createPayment(payment, true);
            } else {
                paymentService.createPayment(payment, false);

            }

        } catch (Exception exception) {
            apiService.sendLog(new Error(payment.getPaymentId(), ErrorType.network, exception.getMessage()));

        }
    }
}
