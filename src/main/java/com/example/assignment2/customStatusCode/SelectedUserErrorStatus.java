package com.example.assignment2.customStatusCode;

import com.example.assignment2.dto.CustomerStatus;
import com.example.assignment2.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SelectedUserErrorStatus implements CustomerStatus {
    private int statusCode;
    private String statusMessage;
}
