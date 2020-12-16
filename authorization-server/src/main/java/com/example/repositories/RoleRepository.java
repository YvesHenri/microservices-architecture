package com.example.repositories;

import com.example.models.Role;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RoleRepository extends ReactiveMongoRepository<Role, String> {
}
