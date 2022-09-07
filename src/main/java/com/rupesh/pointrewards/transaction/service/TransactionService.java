package com.rupesh.pointrewards.transaction.service;

import com.rupesh.pointrewards.transaction.entity.CustomerReward;

import java.util.List;

/**
 * @author abishek on 2022-09-02
 */
public interface TransactionService {
    List<CustomerReward> getRewardPointsByQuarter();
}
