package com.example.assignment2.entity.impl;

import com.example.assignment2.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Orders")

public class OrderEntity implements SuperEntity {

    @Id
    private String orderId;
    @ManyToOne
    @JoinColumn(name = "cusId",nullable = false)
    private CustomerEntity cusId;
    @ManyToOne
    @JoinColumn(name = "itemCode",nullable = false)
    private ItemEntity itemCode;
    private String qtyOnHand;
    private String cusName;
    private String itemDesc;
    private int qty;
    private String price;
    private String total;
}


