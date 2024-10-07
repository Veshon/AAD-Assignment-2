package com.example.assignment2.entity.impl;

import com.example.assignment2.entity.SuperEntity;
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

public class ItemEntity implements SuperEntity {

    @Id
    private String itemCode;
    @Column(unique = true)
    private String itemDesc;
    private String itemQty;
    private String price;
}
