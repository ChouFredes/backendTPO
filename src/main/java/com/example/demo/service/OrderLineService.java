package com.example.demo.service;

import java.util.Optional;

import com.example.demo.Entities.OrderLine;
import com.example.demo.exceptions.OrderLineDuplicateException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface OrderLineService {
    public Page<OrderLine> getOrderLines(PageRequest pageRequest);

    public Optional<OrderLine> getOrderLinesById(Long orderLineId);

    public OrderLine createOrderline(Long productId, Long orderId, Long qty, Long price)
            throws OrderLineDuplicateException;
}
