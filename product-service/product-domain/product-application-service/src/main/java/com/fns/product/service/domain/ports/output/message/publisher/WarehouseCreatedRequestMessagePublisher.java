package com.fns.product.service.domain.ports.output.message.publisher;

import com.fns.domain.event.publisher.DomainEventPublisher;
import com.fns.product.service.domain.event.WarehouseCreatedEvent;
import org.springframework.stereotype.Component;

public interface WarehouseCreatedRequestMessagePublisher extends DomainEventPublisher<WarehouseCreatedEvent> {

}
