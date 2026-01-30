package com.project.ecommercestore.mappers;

import com.project.ecommercestore.dtos.ProductDto;
import com.project.ecommercestore.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category.id", target= "categoryId")
    ProductDto productDto(Product product);

    Product toEntity(ProductDto product);

    @Mapping(target="id", ignore = true)
    void update(@MappingTarget Product product, ProductDto productDto);
}
