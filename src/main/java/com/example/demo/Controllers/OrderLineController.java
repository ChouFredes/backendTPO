package com.example.demo.Controllers;

import com.example.demo.Entities.OrderLine;

import com.example.demo.Request.OrderLineRequest;
import com.example.demo.exceptions.OrderLineDuplicateException;
import com.example.demo.service.OrderLineService;
import com.example.demo.service.OrderLineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("orderlines")
public class OrderLineController {
    @Autowired
    private OrderLineService orderLineService;

    @GetMapping
    public ResponseEntity<Page<OrderLine>> getOrderLines(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
                if (page == null || size == null)
                    return ResponseEntity.ok(orderLineService.getOrderLines(PageRequest.of(0,Integer.MAX_VALUE)));
                return ResponseEntity.ok(orderLineService.getOrderLines(PageRequest.of(page,size)));
    }

    @GetMapping("/{orderLineId}")
    public ResponseEntity<OrderLine> getOrderLineById (@PathVariable Long orderLineId){
        Optional<OrderLine> result = orderLineService.getOrderLinesById(orderLineId);
        if(result.isPresent())
            return ResponseEntity.ok(result.get());
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> createOrderLine (@RequestBody OrderLineRequest orderLineRequest)
        throws OrderLineDuplicateException{
        OrderLine result = orderLineService.createOrderline(orderLineRequest.getProductId(),
                                                            orderLineRequest.getOrderId(),
                                                            orderLineRequest.getQty(),
                                                            orderLineRequest.getPrice());
        return ResponseEntity.created(URI.create("/categories/"+ result.getId())).body(result);
    }
}
