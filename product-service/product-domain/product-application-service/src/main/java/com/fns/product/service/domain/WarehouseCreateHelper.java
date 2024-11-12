package com.fns.product.service.domain;

import com.fns.product.service.domain.dto.create.CreateWarehouseCommand;
import com.fns.product.service.domain.dto.create.StockTransferCommand;
import com.fns.product.service.domain.entity.*;
import com.fns.product.service.domain.event.*;
import com.fns.product.service.domain.exception.StockException;
import com.fns.product.service.domain.exception.WarehouseDomainException;
import com.fns.product.service.domain.mapper.WarehouseDataMapper;
//import com.fns.product.service.domain.ports.output.message.publisher.WarehouseCreatedRequestMessagePublisher;
//import com.fns.product.service.domain.ports.output.repository.StockRepository;
//import com.fns.product.service.domain.ports.output.message.publisher.StockRequestRequestMessagePublisher;
import com.fns.product.service.domain.ports.output.message.publisher.StockRequestRequestMessagePublisher;
import com.fns.product.service.domain.ports.output.repository.WarehouseRepository;
//import com.fns.product.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Slf4j
@Component
public class WarehouseCreateHelper {
    private final WarehouseDomainService warehouseDomainService;

    private final WarehouseRepository warehouseRepository;

    private final WarehouseDataMapper warehouseDataMapper;

//    private final StockRequestRequestMessagePublisher stockRequestRequestMessagePublisher;


    public WarehouseCreateHelper(WarehouseDomainService warehouseDomainService,
                                 WarehouseRepository warehouseRepository,
                                 WarehouseDataMapper warehouseDataMapper
//                                 StockRequestRequestMessagePublisher stockRequestRequestMessagePublisher
                                 ) {
        this.warehouseDomainService = warehouseDomainService;
        this.warehouseRepository = warehouseRepository;
        this.warehouseDataMapper = warehouseDataMapper;
//        this.stockRequestRequestMessagePublisher = stockRequestRequestMessagePublisher;
    }

    @Transactional
    public WarehouseCreatedEvent persistWarehouse(CreateWarehouseCommand createWarehouseCommand) {
        Warehouse warehouse = warehouseDataMapper.createWarehouseCommandToWarehouse(createWarehouseCommand);
        WarehouseCreatedEvent warehouseCreatedEvent = warehouseDomainService.createWarehouse(
                warehouse.getName(),
                warehouse.getLocation());

        saveWarehouse(warehouse);

        log.info("Warehouse is created with id: {}", warehouseCreatedEvent.getEntity().getId().getValue());
        return warehouseCreatedEvent;
    }

    private Warehouse saveWarehouse(Warehouse warehouse) {
        Warehouse warehouseResult = warehouseRepository.save(warehouse);
        if (warehouseResult == null) {
            log.error("Could not save order!");
            throw new WarehouseDomainException("Could not save order!");
        }
        log.info("Warehouse is saved with id: {}", warehouseResult.getId().getValue());
        return warehouseResult;
    }

//    @Transactional
//    public StockTransferRequestedEvent requestedStockTransferEvent(StockTransferCommand stockTransferCommand) {
//        Stock sourceStock = getWarehouse(stockTransferCommand.getSourceStockId());
//        Stock destinationStock = getWarehouse(stockTransferCommand.getDestinationStockId());
//
//        StockTransferRequestedEvent stockTransferRequestedEvent = warehouseDomainService.requestStockTransfer(
//                sourceStock,destinationStock,
//                stockTransferCommand.getQty(),
//                stockTransferCommand.getTransferType(),
//                stockRequestRequestMessagePublisher);
//
//        log.info("Stock is requested with id: {}", stockTransferRequestedEvent.getEntity().getId().getValue());
//        return stockTransferRequestedEvent;
//    }

    private Warehouse getWarehouse(UUID warehouseId) {
        Warehouse whResult = warehouseRepository.findById(warehouseId);
        if (whResult == null) {
            log.error("Data not found");
            throw new StockException("Data not found");
        }
        return whResult;
    }

}
