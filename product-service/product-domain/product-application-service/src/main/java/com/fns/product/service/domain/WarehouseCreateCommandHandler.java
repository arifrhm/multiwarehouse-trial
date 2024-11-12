package com.fns.product.service.domain;

import com.fns.product.service.domain.dto.create.CreateWarehouseCommand;
import com.fns.product.service.domain.dto.create.CreateWarehouseResponse;
import com.fns.product.service.domain.dto.create.StockTransferCommand;
import com.fns.product.service.domain.dto.create.StockTransferResponse;
import com.fns.product.service.domain.event.StockTransferRequestedEvent;
import com.fns.product.service.domain.event.WarehouseCreatedEvent;
import com.fns.product.service.domain.mapper.WarehouseDataMapper;
//import com.fns.product.service.domain.ports.output.message.publisher.StockRequestRequestMessagePublisher;
import com.fns.product.service.domain.ports.output.message.publisher.StockRequestRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WarehouseCreateCommandHandler {
    private final WarehouseCreateHelper warehouseCreateHelper;

    private final WarehouseDataMapper warehouseDataMapper;

//    private final WarehouseCreatedRequestMessagePublisher warehouseCreatedRequestMessagePublisher;

//    private final StockRequestRequestMessagePublisher stockRequestRequestMessagePublisher;

    public WarehouseCreateCommandHandler(WarehouseCreateHelper warehouseCreateHelper,
                                         WarehouseDataMapper warehouseDataMapper
//                                         StockRequestRequestMessagePublisher stockRequestRequestMessagePublisher
                                    ) {
        this.warehouseCreateHelper = warehouseCreateHelper;
        this.warehouseDataMapper = warehouseDataMapper;
//        this.warehouseCreatedRequestMessagePublisher = warehouseCreatedRequestMessagePublisher;
//        this.stockRequestRequestMessagePublisher = stockRequestRequestMessagePublisher;
    }

    public CreateWarehouseResponse createWarehouse(CreateWarehouseCommand createWarehouseCommand) {
        WarehouseCreatedEvent warehouseCreatedEvent = warehouseCreateHelper.persistWarehouse(createWarehouseCommand);
        log.info("Warehouse is created with id: {}", warehouseCreatedEvent.getEntity().getId().getValue());
//        warehouseCreatedRequestMessagePublisher.publish(warehouseCreatedEvent);
        return warehouseDataMapper.warehouseToCreateWarehouseResponse(warehouseCreatedEvent.getEntity(),
                "Warehouse created successfully");
    }


//    public StockTransferResponse transferStock(StockTransferCommand stockTransferCommand) {
//        StockTransferRequestedEvent stockTransferRequestedEvent = warehouseCreateHelper.requestedStockTransferEvent(stockTransferCommand);
//        log.info("Stock is requested with id: {}", stockTransferRequestedEvent.getEntity().getId().getValue());
//
//        stockRequestRequestMessagePublisher.publish(stockTransferRequestedEvent);
//        return warehouseDataMapper.warehouseToCreateWarehouseResponse(stockTransferRequestedEvent.getEntity(),
//                "Stock requested successfully");
//    }
}
