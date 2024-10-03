package com.example.assignment2.entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(unique = true)
    private String cusId;
    @Column(unique = true)
    private String itemId;
    private int qtyOnHand;
    private String cusName;
    private String itemDesc;
    private int qty;
    private double price;
    private double total;
}

