package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderLine {

    public OrderLine(Long productId, Long orderId, Long qty, Long price) {
        this.orderId = orderId;
        this.productId = productId;
        this.qty =qty;
        this.price = price;
    }
    public OrderLine(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long productId;

    @Column
    private Long orderId;

    @Column
    private Long qty;

    @Column
    private Long price;


}
