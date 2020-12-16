package com.example.repositories;

import com.example.models.Scope;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ScopeRepository extends ReactiveMongoRepository<Scope, String> {
}
