package com.fns.product.service.domain.ports.output.repository;

import com.fns.product.service.domain.entity.*;

import java.util.UUID;

public interface WarehouseRepository  {
    Warehouse save(Warehouse warehouse);

    Warehouse findById(UUID warehouseId);
}
