package com.example.demo.service;

import com.example.demo.Entities.ShopOrder;
import com.example.demo.Repositories.ShopOrderRepository;
import com.example.demo.exceptions.ShopOrderDuplicateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class ShopOrderServiceImpl implements ShopOrderService{
    @Autowired
    private ShopOrderRepository shopOrderRepository;

    @Override
    public Page<ShopOrder> getShopOrders(PageRequest pageable) {
        return shopOrderRepository.findAll(pageable);
    }

    @Override
    public Optional<ShopOrder> getShopOrderById(Long shopOrderId) {
        return shopOrderRepository.findById(shopOrderId);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ShopOrder createShopOrder(Long userId, Date date, Long orderTotal) throws ShopOrderDuplicateException {
        return shopOrderRepository.save(new ShopOrder(userId,date,orderTotal));
    }
}
