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
@Table(name = "Customer")

public class CustomerIMPL {

    @Id
    private String cusId;
    private String cusName;
    private String cusAddress;
    private int cusTeleNo;
}
