package com.example.assignment2.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Orders")

public class OrderEntity {

    @Id
    private String orderId;
    @JoinColumn(name = "cusId",nullable = false)
    private String cusId;
    @JoinColumn(name = "itemCode",nullable = false)
    private String itemCode;
    private String qtyOnHand;
    private String cusName;
    private String itemDesc;
    private int qty;
    private String price;
    private String total;
}

