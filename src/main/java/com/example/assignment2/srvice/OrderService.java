package com.example.assignment2.srvice;

import com.example.assignment2.dto.ItemStatus;
import com.example.assignment2.dto.OrderStatus;
import com.example.assignment2.dto.impl.ItemDTO;
import com.example.assignment2.dto.impl.OrderDTO;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
    void deleteOrder(String orderId);

}
