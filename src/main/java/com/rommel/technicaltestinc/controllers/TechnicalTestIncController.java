package com.rommel.technicaltestinc.controllers;

import com.rommel.technicaltestinc.models.Account;
import com.rommel.technicaltestinc.models.Payment;
import com.rommel.technicaltestinc.models.PaymentType;
import com.rommel.technicaltestinc.services.AccountService;
import com.rommel.technicaltestinc.services.PaymentService;
import com.rommel.technicaltestinc.utils.DateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;

@RestController
public class TechnicalTestIncController {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }
}
