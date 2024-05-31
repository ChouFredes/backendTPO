package com.example.demo.service;

import com.example.demo.Entities.ShopOrder;
import com.example.demo.exceptions.ShopOrderDuplicateException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.Optional;

public interface ShopOrderService {
    public Page<ShopOrder> getShopOrders(PageRequest pageRequest);

    public Optional<ShopOrder> getShopOrderById (Long shopOrderId);

    public ShopOrder createShopOrder(Long userId, Date date, Long orderTotal) throws ShopOrderDuplicateException;
}
