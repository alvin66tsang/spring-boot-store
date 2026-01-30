package com.project.ecommercestore.repositories;

import com.project.ecommercestore.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}