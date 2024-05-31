package com.example.demo.service;

import com.example.demo.Entities.OrderLine;
import com.example.demo.Repositories.OrderLineRepository;
import com.example.demo.exceptions.OrderLineDuplicateException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderLineServiceImpl implements OrderLineService{
    @Autowired
    private OrderLineRepository orderLineRepository;

    public Page<OrderLine> getOrderLines(PageRequest pageable) { return (Page<OrderLine>) orderLineRepository.findAll(pageable);}

    public Optional<OrderLine> getOrderLinesById(Long id) {
        return orderLineRepository.findById(id);
    }

    @Transactional(rollbackFor = Throwable.class)
    public OrderLine createOrderline(Long productId, Long orderId, Long qty, Long price) throws OrderLineDuplicateException {
        return orderLineRepository.save(new OrderLine(productId,orderId,qty,price));
    }
}
