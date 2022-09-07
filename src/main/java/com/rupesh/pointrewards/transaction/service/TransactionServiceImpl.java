package com.rupesh.pointrewards.transaction.service;

import com.rupesh.pointrewards.customer.entity.Customer;
import com.rupesh.pointrewards.transaction.entity.CustomerReward;
import com.rupesh.pointrewards.transaction.entity.Transaction;
import com.rupesh.pointrewards.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author abishek on 2022-09-02
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<CustomerReward> getRewardPointsByQuarter() {
        List<Transaction> transactions = transactionRepository.findAll();
        Map<Customer, List<Transaction>> transactionGroupByCustomer = transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getCustomer, Collectors.toList()));

        List<CustomerReward> customerRewards = new ArrayList<>();

        for (var transactionEntry : transactionGroupByCustomer.entrySet()) {
            CustomerReward customerReward = getCustomerReward(transactionEntry.getValue());
            customerReward.setCustomerName(transactionEntry.getKey().getName());
            customerRewards.add(customerReward);
        }
        return customerRewards;
    }



    private CustomerReward getCustomerReward(List<Transaction> transactions) {
        Map<String, Integer> rewardsCollectedByMonth = transactions
                .stream()
                .map(trans -> {
                    String month = trans.getTransactionDate().getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
                    int amount = calculateReward(trans.getAmountSpent());
                    return Pair.of(month, amount);
                }).collect(Collectors.groupingBy(Pair::getFirst, Collectors.summingInt(Pair::getSecond)));
        CustomerReward customerReward = new CustomerReward();
        customerReward.setRewards(rewardsCollectedByMonth);
        int total = rewardsCollectedByMonth.values().stream().mapToInt(i -> i).sum();
        customerReward.setTotal(total);
        return customerReward;
    }


    private int calculateReward(int amountSpent) {
        if (amountSpent < 50) {
            return 0;
        }
        if (amountSpent >= 100) {
            return 50 + (amountSpent - 100) * 2;
        }
        return amountSpent - 50;
    }

}
