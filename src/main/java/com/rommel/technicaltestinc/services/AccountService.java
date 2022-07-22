package com.rommel.technicaltestinc.services;

import com.rommel.technicaltestinc.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;



@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public int updateLastPaymentDateById (Timestamp lastPaymentDate, int id) {
        return accountRepository.updateLastPaymentDateById(lastPaymentDate, id);
    }

}
