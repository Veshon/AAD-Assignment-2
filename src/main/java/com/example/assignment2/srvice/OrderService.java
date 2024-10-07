package com.example.assignment2.srvice;

import com.example.assignment2.dto.impl.ItemDTO;
import com.example.assignment2.dto.impl.OrderDTO;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    void deleteOrder(String orderId);


}
