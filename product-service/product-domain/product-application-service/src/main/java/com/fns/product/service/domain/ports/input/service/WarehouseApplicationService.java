package com.fns.product.service.domain.ports.input.service;

import com.fns.product.service.domain.dto.create.CreateWarehouseCommand;
import com.fns.product.service.domain.dto.create.CreateWarehouseResponse;
import com.fns.product.service.domain.dto.create.StockTransferCommand;
import com.fns.product.service.domain.dto.create.StockTransferResponse;
//import com.fns.product.service.domain.dto.track.TrackOrderQuery;
//import com.fns.product.service.domain.dto.track.TrackOrderResponse;

import javax.validation.Valid;

public interface WarehouseApplicationService {
    CreateWarehouseResponse createWarehouse(@Valid CreateWarehouseCommand createOrderCommand);

//    StockTransferResponse transferStock(@Valid StockTransferCommand stockTransferCommand);

}
