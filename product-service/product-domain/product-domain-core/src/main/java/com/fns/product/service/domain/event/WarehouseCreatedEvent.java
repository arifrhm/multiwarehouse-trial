package com.fns.product.service.domain.event;

import com.fns.product.service.domain.entity.Warehouse;
import java.time.ZonedDateTime;

public class WarehouseCreatedEvent extends WarehouseEvent {
    public WarehouseCreatedEvent(Warehouse warehouse, ZonedDateTime createdAt) {
        super(warehouse, createdAt);
    }

    @Override
    public void fire() {

    }
}
