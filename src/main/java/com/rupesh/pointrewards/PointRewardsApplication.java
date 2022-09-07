package com.rupesh.pointrewards;

import com.rupesh.pointrewards.transaction.entity.CustomerReward;
import com.rupesh.pointrewards.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PointRewardsApplication  {

    public static void main(String[] args) {
        SpringApplication.run(PointRewardsApplication.class, args);
    }


}
