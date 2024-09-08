package com.example.scm.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scm.entities.OrderItem;
import com.example.scm.repsitories.OrderItemRepository;
import com.example.scm.repsitories.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        // Ensure the order is saved first
        if (orderItem.getOrder() != null) {
            // Check if the Order is new and needs to be saved
            if (orderItem.getOrder().getid() == null) {
                orderRepository.save(orderItem.getOrder());
            }
        }

        // Now save the OrderItem
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItem updatedOrderItem) {
        return orderItemRepository.findById(id).map(orderItem -> {
            orderItem.setOrder(updatedOrderItem.getOrder());
            orderItem.setProduct(updatedOrderItem.getProduct());
            orderItem.setQuantity(updatedOrderItem.getQuantity());
            return orderItemRepository.save(orderItem);
        }).orElse(null);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
