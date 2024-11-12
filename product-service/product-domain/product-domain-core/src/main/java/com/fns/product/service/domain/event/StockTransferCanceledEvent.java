package com.fns.product.service.domain.event;

import com.fns.domain.event.publisher.DomainEventPublisher;
import com.fns.product.service.domain.entity.Stock;

import java.time.ZonedDateTime;

public class StockTransferCanceledEvent extends StockTransferEvent {
    private final DomainEventPublisher<StockTransferCanceledEvent> eventPublisher;

    public StockTransferCanceledEvent(Stock sourceStock, Stock destinationStock, int quantity, ZonedDateTime createdAt, DomainEventPublisher<StockTransferCanceledEvent> eventPublisher) {
        super(sourceStock, destinationStock, quantity, createdAt);
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void fire() {
        eventPublisher.publish(this);
    }
}
