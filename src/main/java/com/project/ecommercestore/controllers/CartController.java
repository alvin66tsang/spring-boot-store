package com.project.ecommercestore.controllers;

import com.project.ecommercestore.dtos.AddItemToCartRequest;
import com.project.ecommercestore.dtos.CartDto;
import com.project.ecommercestore.dtos.CartItemDto;
import com.project.ecommercestore.dtos.UpdateCartItemRequest;
import com.project.ecommercestore.exceptions.CartNotFoundException;
import com.project.ecommercestore.exceptions.ProductNotFoundException;
import com.project.ecommercestore.services.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/carts")
@AllArgsConstructor
@Tag(name = "Carts")
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> createCart() {

        var cartDto = cartService.createCart();
        return ResponseEntity.ok().body(cartDto);
    }

    @Operation(summary = "Add a product to the cart")
    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartItemDto> addToCart(
            @Parameter(description = "ID of the cart")
            @PathVariable UUID cartId,
            @RequestBody AddItemToCartRequest rq
    ) {

        var cartItemDto = cartService.addToCart(cartId, rq.getProductId());
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemDto);
    }

    @GetMapping("/{cartId}")
    public CartDto getCart(@PathVariable UUID cartId) {

        return cartService.getCart(cartId);
    }

    @PutMapping("/{cartId}/items/{productId}")
    public CartItemDto updateCartItem(
            @PathVariable UUID cartId,
            @PathVariable Long productId,
            @Valid @RequestBody UpdateCartItemRequest rq
            ) {

        return cartService.updateCartItem(cartId, productId, rq.getQuantity());
    }

    @DeleteMapping("{cartId}/items/{productId}")
    public ResponseEntity<?> deleteCart(
            @PathVariable UUID cartId,
            @PathVariable Long productId
    ) {

        cartService.deleteCartItem(cartId, productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{cartId}/items")
    public ResponseEntity<Void> clearCart(
            @PathVariable UUID cartId
    ) {
        cartService.clearCart(cartId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCartNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Cart not found"));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFound() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Product not found in the cart"));
    }
}

