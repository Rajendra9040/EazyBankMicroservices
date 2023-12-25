package com.microservice.accounts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "accounts")
public class Account extends BaseModel {
    @Id
    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "account_type")
    private AccountType accountType;

    @Column(name = "customer_id")
    private Long customerId;
}
