package com.example.banking.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Customer {
    @Id
    private long cust_id;
    private String cust_name;
    private String email;
    private long acc_bal;
}
