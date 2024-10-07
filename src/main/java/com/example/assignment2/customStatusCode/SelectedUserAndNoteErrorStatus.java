package com.example.assignment2.customStatusCode;

import com.example.assignment2.dto.*;
import com.example.assignment2.dto.CustomerStatus;
import com.example.assignment2.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErrorStatus implements CustomerStatus, ItemStatus, OrderStatus {
    private int statusCode;
    private String statusMessage;
}
