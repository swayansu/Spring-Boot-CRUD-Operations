package com.example.banking.repositories;

import com.example.banking.entities.Admin;
import com.example.banking.entities.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository <Admin, Long> {
}
