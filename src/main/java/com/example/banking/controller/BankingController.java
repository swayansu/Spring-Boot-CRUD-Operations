package com.example.banking.controller;

import com.example.banking.entities.Customer;
import com.example.banking.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BankingController {

    @Autowired
    private final BankingService bankingService;

    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @GetMapping(value = "/cust")
    public List<Customer> getAllCustomer(){
        return bankingService.getAllCustomers();
    }

    @PostMapping(value = "/cust")
    public String addNewCustomer(@RequestBody Customer customer){
            return bankingService.addNewCutsomer(customer);
    }

    @PutMapping(value = "/cust/{semail}/{remail}/{amount}")
    public String updateCustomerBal(@PathVariable String semail,
                                  @PathVariable String remail, @PathVariable String amount){
        return bankingService.updateCustomerBal(semail,remail,amount);
    }

    @DeleteMapping(value = "/cust/{email}")
    public String deleteCustomer(@PathVariable String email){
        return bankingService.deleteCustomer(email);
    }
}
