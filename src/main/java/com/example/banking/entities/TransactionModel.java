package com.example.banking.entities;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Getter
@Setter
@ToString
public class TransactionModel extends AbstractPersistable<Long> {
    private String senderEmail;
    private String receiverEmail;
    private String amount;
}
