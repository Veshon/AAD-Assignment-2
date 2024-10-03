package com.example.assignment2.entity.impl;

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
@Table(name = "Item")

public class ItemIMPL {

    @Id
    private String ItemCode;
    private String ItemDesc;
    private int ItemQty;
    private double price;
}
