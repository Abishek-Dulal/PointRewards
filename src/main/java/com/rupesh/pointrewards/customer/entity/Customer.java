package com.rupesh.pointrewards.customer.entity;

import com.rupesh.pointrewards.transaction.entity.Transaction;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * @author abishek on 2022-09-02
 */
@Getter
@Setter
public class Customer {

    private Long id;

    private String name;



}
