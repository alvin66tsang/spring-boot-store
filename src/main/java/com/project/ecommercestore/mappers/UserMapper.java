package com.project.ecommercestore.mappers;

import com.project.ecommercestore.dtos.RegisterUserRequest;
import com.project.ecommercestore.dtos.UpdateUserRequest;
import com.project.ecommercestore.dtos.UserDto;
import com.project.ecommercestore.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);

    void update(@MappingTarget User user, UpdateUserRequest request);
}
