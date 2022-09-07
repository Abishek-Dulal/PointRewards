package com.rupesh.pointrewards.transaction.entity;

import com.rupesh.pointrewards.customer.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author abishek on 2022-09-02
 */
@Getter
@Setter
public class Transaction {

    private Long transactionId;

    private LocalDateTime transactionDate;


    private int amountSpent;

    private Customer customer;

}
