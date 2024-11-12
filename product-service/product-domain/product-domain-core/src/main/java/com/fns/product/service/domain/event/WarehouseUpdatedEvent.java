package com.fns.product.service.domain.event;

import com.fns.product.service.domain.entity.Warehouse;
import java.time.ZonedDateTime;

public class WarehouseUpdatedEvent extends WarehouseEvent {

    public WarehouseUpdatedEvent(Warehouse warehouse, ZonedDateTime updatedAt) {
        super(warehouse, updatedAt);
    }

    @Override
    public void fire() {

    }
}
