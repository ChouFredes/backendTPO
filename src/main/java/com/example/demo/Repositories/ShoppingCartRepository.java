package com.example.demo.Repositories;

import com.example.demo.Entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    // Puedes agregar métodos adicionales de consulta si es necesario
}

