package com.rupesh.pointrewards.transaction.controller;

import com.rupesh.pointrewards.transaction.entity.CustomerReward;
import com.rupesh.pointrewards.transaction.repository.TransactionRepository;
import com.rupesh.pointrewards.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author abishek on 2022-09-02
 */
@RestController
@RequestMapping("/v1/transaction")
public class TransactionController {


    @Autowired
    private TransactionService transactionService;


    @GetMapping("/reward")
    public ResponseEntity<List<CustomerReward>> getRewardPointsByQuarter() {
        List<CustomerReward> rewardPointsByQuarter = transactionService.getRewardPointsByQuarter();
        return ResponseEntity.ok(rewardPointsByQuarter);
    }




}
