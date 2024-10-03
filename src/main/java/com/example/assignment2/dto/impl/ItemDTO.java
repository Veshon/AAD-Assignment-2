package com.example.assignment2.dto.impl;

import com.example.assignment2.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemDTO implements ItemStatus {

    private String ItemCode;
    private String ItemDesc;
    private String ItemQty;
    private String price;

}
