package com.fns.product.service.domain.event;

import com.fns.product.service.domain.entity.Stock;

import java.time.ZonedDateTime;

public class StockUpdatedEvent extends StockEvent {
    private final int quantityChange;

    public StockUpdatedEvent(Stock stock, int quantityChange, ZonedDateTime updatedAt) {
        super(stock, updatedAt);
        this.quantityChange = quantityChange;
    }

    public int getQuantityChange() {
        return quantityChange;
    }

    @Override
    public void fire() {

    }
}
