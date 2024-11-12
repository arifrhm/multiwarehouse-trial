package com.fns.product.service.domain.ports.output.repository;

import com.fns.product.service.domain.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID userId);
}
