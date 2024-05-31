package com.example.demo.Controllers;

import com.example.demo.Entities.ShopOrder;
import com.example.demo.Repositories.ShopOrderRepository;
import com.example.demo.Request.ShopOrderRequest;
import com.example.demo.exceptions.ShopOrderDuplicateException;
import com.example.demo.service.ShopOrderService;
import org.apache.coyote.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shoporders")
public class ShopOrderController {
    @Autowired
    private ShopOrderService shopOrderService;

    @GetMapping
    public ResponseEntity<Page<ShopOrder>> getShopOrders(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        if (page == null || size == null)
            return ResponseEntity.ok(shopOrderService.getShopOrders(PageRequest.of(0, Integer.MAX_VALUE)));
        return ResponseEntity.ok(shopOrderService.getShopOrders(PageRequest.of(page,size)));
    }

    @GetMapping("/{shopOrderId}")
    public ResponseEntity<ShopOrder> getShopOrderById (@PathVariable Long shopOrderId){
        Optional<ShopOrder> result = shopOrderService.getShopOrderById(shopOrderId);
        if(result.isPresent())
            return ResponseEntity.ok(result.get());
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> createShopOrder (@RequestBody ShopOrderRequest shopOrderRequest)
        throws ShopOrderDuplicateException{
        ShopOrder result = shopOrderService.createShopOrder(shopOrderRequest.getUserID(),shopOrderRequest.getDate(),shopOrderRequest.getOrderTotal());
        return ResponseEntity.created(URI.create("/categories/" + result.getId())).body(result);
    }
}
