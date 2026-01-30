package com.project.ecommercestore.mappers;

import com.project.ecommercestore.dtos.CartDto;
import com.project.ecommercestore.dtos.CartItemDto;
import com.project.ecommercestore.entities.Cart;
import com.project.ecommercestore.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.beans.Expression;

@Mapper(componentModel = "spring")
public interface CartMapper {

    @Mapping(target="totalPrice", expression="java(cart.getTotalPrice())")
    CartDto toDto(Cart cart);
    @Mapping(target="totalPrice", expression="java(cartItem.getTotalPrice())")
    CartItemDto toDto(CartItem cartItem);
}
