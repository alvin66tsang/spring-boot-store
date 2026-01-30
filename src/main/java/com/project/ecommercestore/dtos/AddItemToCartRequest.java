package com.project.ecommercestore.dtos;


import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class AddItemToCartRequest {

    @NotNull
    private Long productId;
}
