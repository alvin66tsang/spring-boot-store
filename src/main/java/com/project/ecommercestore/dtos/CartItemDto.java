package com.project.ecommercestore.dtos;

import com.project.ecommercestore.entities.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDto {

    private CartProductDto product;
    private int quantity;
    private BigDecimal totalPrice;
}
