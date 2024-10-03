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
@Table(name = "Item")

public class ItemEntity {

    @Id
    private String ItemCode;
    @Column(unique = true)
    private String ItemDesc;
    private String ItemQty;
    private String price;
}
