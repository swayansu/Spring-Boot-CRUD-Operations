package com.example.banking.repositories;

import com.example.banking.entities.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<TransactionModel,Long> {

    TransactionModel findAllByAmount(String amount);
}
