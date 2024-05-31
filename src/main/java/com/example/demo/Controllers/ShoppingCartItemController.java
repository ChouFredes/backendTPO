package com.example.demo.Controllers;

import com.example.demo.Entities.ShoppingCartItem;
import com.example.demo.Entities.ShoppingCart;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.Repositories.ShoppingCartItemRepository;
import com.example.demo.Repositories.ShoppingCartRepository;
import java.util.List;

@RestController
@RequestMapping("/shopping_cart_items")
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @GetMapping("/{cartId}")
    public List<ShoppingCartItem> getShoppingCartItems(@PathVariable Long cartId) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return cart.getItems();
    }

    @PostMapping("/{cartId}")
    public ShoppingCartItem createShoppingCartItem(@PathVariable Long cartId, @RequestBody ShoppingCartItem shoppingCartItem) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        shoppingCartItem.setCartId(cart);
        return shoppingCartItemRepository.save(shoppingCartItem);
    }

    @GetMapping("/{cartId}/{itemId}")
    public ShoppingCartItem getShoppingCartItem(@PathVariable Long cartId, @PathVariable Long itemId) {
        ShoppingCartItem item = shoppingCartItemRepository.findById(itemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // Verifica si el item pertenece al carrito especificado
        if (!item.getCartId().getId().equals(cartId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return item;
    }

    @PutMapping("/{cartId}/{itemId}")
    public ShoppingCartItem updateShoppingCartItem(@PathVariable Long cartId, @PathVariable Long itemId, @RequestBody ShoppingCartItem shoppingCartItem) {
        ShoppingCartItem itemActual = shoppingCartItemRepository.findById(itemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // Verifica si el item pertenece al carrito especificado
        if (!itemActual.getCartId().getId().equals(cartId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        // Actualiza los campos necesarios del item
        itemActual.setProductItemId(shoppingCartItem.getProductItemId());
        itemActual.setQuantity(shoppingCartItem.getQuantity());
        return shoppingCartItemRepository.save(itemActual);
    }

    @DeleteMapping("/{cartId}/{itemId}")
    public void deleteShoppingCartItem(@PathVariable Long cartId, @PathVariable Long itemId) {
        ShoppingCartItem item = shoppingCartItemRepository.findById(itemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // Verifica si el item pertenece al carrito especificado
        if (!item.getCartId().getId().equals(cartId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        shoppingCartItemRepository.deleteById(itemId);
    }
}
