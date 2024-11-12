package com.fns.product.service.domain.ports.output.repository;

import com.fns.product.service.domain.entity.Stock;

import java.util.UUID;

public interface StockRepository {
    void initializeDefaultInventory(UUID warehouseId);
}
