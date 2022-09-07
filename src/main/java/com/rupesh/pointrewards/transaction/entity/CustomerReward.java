package com.rupesh.pointrewards.transaction.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author abishek on 2022-09-07
 */
@Getter
@Setter
public class CustomerReward {

    private String customerName;

    private Map<String,Integer> rewards;

    private int total;


}
