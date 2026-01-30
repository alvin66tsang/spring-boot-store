package com.project.ecommercestore.mappers;

import com.project.ecommercestore.dtos.OrderDto;
import com.project.ecommercestore.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "total", source = "totalPrice")
    OrderDto toDto(Order order);
}
