package com.fns.product.service.domain.ports.output.message.publisher;

import com.fns.domain.event.publisher.DomainEventPublisher;
import com.fns.product.service.domain.event.StockTransferRequestedEvent;

public interface StockRequestRequestMessagePublisher extends DomainEventPublisher<StockTransferRequestedEvent>  {
}
