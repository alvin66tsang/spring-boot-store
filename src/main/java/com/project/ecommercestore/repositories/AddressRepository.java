package com.project.ecommercestore.repositories;

import com.project.ecommercestore.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}