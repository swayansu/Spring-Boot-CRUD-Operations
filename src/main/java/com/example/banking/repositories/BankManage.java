package com.example.banking.repositories;

import com.example.banking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankManage extends JpaRepository<Customer,Long>{

    Customer findByemail(String email);
}
