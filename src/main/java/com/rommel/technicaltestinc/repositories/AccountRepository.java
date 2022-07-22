package com.rommel.technicaltestinc.repositories;

import com.rommel.technicaltestinc.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Modifying
    @Query(value = "UPDATE accounts SET last_payment_date = ?1 WHERE account_id = ?2", nativeQuery = true)
    int updateLastPaymentDateById(Timestamp timestamp, int id);

}
