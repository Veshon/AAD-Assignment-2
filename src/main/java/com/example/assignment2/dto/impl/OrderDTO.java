package com.example.assignment2.dto.impl;

import com.example.assignment2.dto.ItemStatus;
import com.example.assignment2.dto.OrderStatus;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDTO implements OrderStatus {

    private String orderId;
    private String cusId;
    private String itemCode;
    private String qtyOnHand;
    private String cusName;
    private String itemDesc;
    private int qty;
    private String price;
    private String total;
}
