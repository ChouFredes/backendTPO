package com.example.demo.Controllers;

import com.example.demo.Entities.ShoppingCart;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.Repositories.ShoppingCartRepository;
import java.util.List;

@RestController
@RequestMapping("/shopping_carts")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @GetMapping
    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    @PostMapping
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @GetMapping("/{id}")
    public ShoppingCart getShoppingCart(@PathVariable Long id) {
        return shoppingCartRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ShoppingCart updateShoppingCart(@PathVariable Long id, @RequestBody ShoppingCart shoppingCart) {
        ShoppingCart cartActual = shoppingCartRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // Actualiza los campos necesarios del carrito
        cartActual.setUserId(shoppingCart.getUserId());

        return shoppingCartRepository.save(cartActual);
    }

    @DeleteMapping("/{id}")
    public void deleteShoppingCart(@PathVariable Long id) {
        shoppingCartRepository.deleteById(id);
    }
}
