package com.example.banking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Getter
@Entity
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
//    private long id;
    private String email;
    private boolean isAdmin = true;
}
