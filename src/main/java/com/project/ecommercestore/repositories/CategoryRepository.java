package com.project.ecommercestore.repositories;

import com.project.ecommercestore.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}