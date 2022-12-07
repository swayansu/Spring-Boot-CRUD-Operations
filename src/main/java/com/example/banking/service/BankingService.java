package com.example.banking.service;


import com.example.banking.entities.Customer;
import com.example.banking.entities.TransactionModel;
import com.example.banking.repositories.AdminRepo;
import com.example.banking.repositories.BankManage;
import com.example.banking.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankingService {

    @Autowired
    private final BankManage bankManage;

    @Autowired
    private  TransactionRepo transactionRepo;

    @Autowired
    private AdminRepo adminRepo;

    public BankingService(BankManage bankManage) {
        this.bankManage = bankManage;
    }

    public List<Customer> getAllCustomers(){
        return bankManage.findAll();
    }

    public String addNewCutsomer(Customer customer) {
        bankManage.save(customer);
        return "Registerd";
    }

    public String updateCustomerBal(String semail, String remail, String amount) {
       Customer senderCust=  bankManage.findByemail(semail);
        Customer receiverCust =  bankManage.findByemail(remail);
       if(senderCust!=null && receiverCust!=null){
           if(senderCust.getAcc_bal()>Long.parseLong(amount)){
               receiverCust.setAcc_bal(receiverCust.getAcc_bal()+Long.parseLong(amount));
               senderCust.setAcc_bal(senderCust.getAcc_bal()-Long.parseLong(amount));
               bankManage.save(receiverCust);
               bankManage.save(senderCust);


               TransactionModel tmodel = new TransactionModel();
               tmodel.setSenderEmail(semail);
               tmodel.setAmount(amount);
               tmodel.setReceiverEmail(remail);
               transactionRepo.save(tmodel);
               return "Success";

           }
           return "insufficient amount";
       }
       return "invalid email";
    }

    public String deleteCustomer(String email){
        if(bankManage.findByemail(email)!= null) {
            bankManage.delete(bankManage.findByemail(email));
            return "Deletion Successful";
        }
        return "No entries found";
    }
}
