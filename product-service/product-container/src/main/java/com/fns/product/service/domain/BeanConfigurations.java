package com.fns.product.service.domain;

import com.fns.product.service.dataaccess.warehouse.adapter.WarehouseRepositoryImpl;
import com.fns.product.service.domain.ports.output.repository.WarehouseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {

    @Bean
    public WarehouseDomainService warehouseDomainService() {
        return new WarehouseDomainServiceImpl();
    }

}