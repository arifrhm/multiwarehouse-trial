package com.fns.product.service.domain;

import com.fns.product.service.domain.entity.*;
import com.fns.product.service.domain.exception.WarehouseDomainException;
import com.fns.product.service.domain.valueobject.*;
import com.fns.product.service.domain.event.*;

import com.fns.domain.event.publisher.DomainEventPublisher;

import java.util.UUID;

public interface WarehouseDomainService {

    WarehouseCreatedEvent createWarehouse(String name, Location location) throws WarehouseDomainException;

    WarehouseUpdatedEvent updateWarehouse(Warehouse warehouse, Location newLocation, String newName) throws WarehouseDomainException;

    WarehouseDeletedEvent deleteWarehouse(Warehouse warehouse) throws WarehouseDomainException;

    Warehouse assignWarehouseAdmin(Warehouse warehouse, User admin) throws WarehouseDomainException;

    StockCreatedEvent createStock(UUID warehouseId, UUID productId, int quantity);

    StockUpdatedEvent updateStock(Stock stock, int quantityChange);

    StockTransferRequestedEvent requestStockTransfer(Stock sourceStock, Stock destinationStock, int quantity, TransferType transferType, DomainEventPublisher<StockTransferRequestedEvent> publisher) throws WarehouseDomainException;
//    StockTransferRequestedEvent requestStockTransfer(Stock sourceStock, Stock destinationStock, int quantity, TransferType transferType) throws WarehouseDomainException;

    StockTransferApprovedEvent approveStockTransfer(Stock sourceStock, Stock destinationStock, int quantity, DomainEventPublisher<StockTransferApprovedEvent> publisher) throws WarehouseDomainException;

    StockTransferCanceledEvent cancelStockTransfer(Stock sourceStock, int quantity, DomainEventPublisher<StockTransferCanceledEvent> publisher) throws WarehouseDomainException;
}
