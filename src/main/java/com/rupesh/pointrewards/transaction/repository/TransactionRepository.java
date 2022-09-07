package com.rupesh.pointrewards.transaction.repository;

import com.rupesh.pointrewards.customer.entity.Customer;
import com.rupesh.pointrewards.transaction.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author abishek on 2022-09-02
 */
@Repository
public class TransactionRepository {

    private List<Transaction> transactions;


    public TransactionRepository(List<Transaction> transactions) {

        Customer customer = new Customer();
        customer.setName("hari");
        customer.setId(1l);

        Transaction transaction = new Transaction();
        transaction.setTransactionDate(LocalDateTime.of(2020, Month.JUNE,2,2,3));
        transaction.setCustomer(customer);
        transaction.setAmountSpent(70);

        this.transactions = transactions;
        this.transactions.add(transaction);
    }





    public List<Transaction> findAll(){
        return transactions;
    }



}
