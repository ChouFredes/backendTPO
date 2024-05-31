package com.example.demo.Repositories;

import com.example.demo.Entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository <OrderLine, Long> {
}
