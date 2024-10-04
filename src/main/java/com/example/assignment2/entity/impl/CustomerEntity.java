package com.example.assignment2.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Customer")

public class CustomerEntity {

    @Id
    private String cusId;
    private String cusName;
    private String cusAddress;
    @Column(unique = true)
    private int cusTeleNo;
}
