package com.rommel.technicaltestinc.repositories;

import com.rommel.technicaltestinc.models.Account;
import com.rommel.technicaltestinc.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
