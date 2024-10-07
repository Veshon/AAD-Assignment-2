package com.example.assignment2.srvice.impl;

import com.example.assignment2.dao.ItemDAO;
import com.example.assignment2.dao.OrderDAO;
import com.example.assignment2.dto.impl.OrderDTO;
import com.example.assignment2.entity.impl.ItemEntity;
import com.example.assignment2.entity.impl.OrderEntity;
import com.example.assignment2.exception.DataPersistException;
import com.example.assignment2.exception.ItemNotFoundException;
import com.example.assignment2.srvice.OrderService;
import com.example.assignment2.util.AppUtil;
import com.example.assignment2.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional

public class OrderServiceIMPL implements OrderService {
    @Autowired
    public OrderDAO orderDAO;

    @Autowired
    public Mapping orderMapping;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        orderDTO.setOrderId(AppUtil.generateOrderId());
        OrderEntity savedOrder =
                orderDAO.save(orderMapping.toOrderEntity(orderDTO));
        if(savedOrder == null){
            throw new DataPersistException("Order not saved");
        }
    }

    @Override
    public void deleteOrder(String orderId) {
        Optional<OrderEntity> foundOrder = orderDAO.findById(orderId);
        if (!foundOrder.isPresent()) {
            throw new ItemNotFoundException("Order not found");
        }else {
            orderDAO.deleteById(orderId);
        }
    }
}
