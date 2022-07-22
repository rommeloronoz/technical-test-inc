package com.rommel.technicaltestinc.services;

import com.google.gson.Gson;
import com.rommel.technicaltestinc.config.AppConfig;
import com.rommel.technicaltestinc.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import com.rommel.technicaltestinc.models.Error;


public class ApiService {

    @Autowired
    private RestTemplate restTemplate;
    private ResponseEntity<String> responseEntity;
    private HttpHeaders httpHeaders;
    private HttpEntity<String> httpEntity;
    private Gson gson;


    public ApiService (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        gson = new Gson();
    }

    private HttpStatus sendPostRequest(String json, String url) {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        httpEntity = new HttpEntity<String>(json, httpHeaders);

        responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                httpEntity,
                String.class
        );

        return responseEntity.getStatusCode();

    }

    public HttpStatus sendLog(Error error) {
        return sendPostRequest(gson.toJson(error), AppConfig.API_URL_BASE + AppConfig.API_URL_LOG_ENDPOINT);

    }

    public HttpStatus validatePayment(Payment payment) {
        return sendPostRequest(gson.toJson(payment), AppConfig.API_URL_BASE + AppConfig.API_URL_VALIDATE_PAYMENT_ENDPOINT);

    }

}
