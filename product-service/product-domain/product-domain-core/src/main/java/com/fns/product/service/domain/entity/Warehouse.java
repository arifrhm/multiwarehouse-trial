package com.fns.product.service.domain.entity;


import com.fns.domain.valueobject.*;
import com.fns.domain.entity.AggregateRoot;
import com.fns.product.service.domain.exception.WarehouseDomainException;
import com.fns.product.service.domain.valueobject.Location;
import com.fns.product.service.domain.valueobject.WarehouseStatus;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AggregateRoot<WarehouseId> {

    private String name;
    private Location location;
    private final List<User> warehouseAdmins;
    private WarehouseStatus status;
    private List<String> failureMessages;

    public static final String FAILURE_MESSAGE_DELIMITER = ",";

    private Warehouse(Builder builder) {
        super.setId(builder.warehouseId);
        this.name = builder.name;
        this.location = builder.location;
        this.warehouseAdmins = new ArrayList<>(builder.warehouseAdmins);
        this.status = builder.status;
        this.failureMessages = builder.failureMessages;

    }

    public static Builder builder() {
        return new Builder();
    }

    public void deactivateWarehouse() {
        this.status = WarehouseStatus.DEACTIVE;
    }

    public void updateName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = newName;
    }

    public void updateLocation(Location newLocation) {
        this.location = newLocation;
    }

    public void assignAdmin(User user) {
        if (!warehouseAdmins.contains(user)) {
            warehouseAdmins.add(user);
        }
    }

    private void updateFailureMessages(List<String> failureMessages) {
        if (this.failureMessages != null && failureMessages != null) {
            this.failureMessages.addAll(failureMessages.stream().filter(message -> !message.isEmpty()).toList());
        }
        if (this.failureMessages == null) {
            this.failureMessages = failureMessages;
        }
    }

    // Getters
    public String getName() { return name; }
    public Location getLocation() { return location; }
    public WarehouseStatus getStatus() { return status; }
    public List<User> getWarehouseAdmins() { return warehouseAdmins; }
    public WarehouseId getWarehouseId() { return getId(); }
    public List<String> getFailureMessages() {
        return failureMessages;
    }

    // Builder class
    public static class Builder {
        private WarehouseId warehouseId;
        private String name;
        private Location location;
        private List<User> warehouseAdmins = new ArrayList<>();
        private WarehouseStatus status = WarehouseStatus.ACTIVE;
        private List<String> failureMessages;


        public Builder warehouseId(WarehouseId warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        public Builder name(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new WarehouseDomainException("Name cannot be null or empty.");
            }
            this.name = name;
            return this;
        }

        public Builder location(Location location) {
            if (location == null) {
                throw new WarehouseDomainException("Location cannot be null.");
            }
            this.location = location;
            return this;
        }

        public Builder warehouseAdmins(List<User> warehouseAdmins) {
            if (warehouseAdmins != null) {
                this.warehouseAdmins = new ArrayList<>(warehouseAdmins);
            }
            return this;
        }

        public Builder failureMessages(List<String> val) {
            this.failureMessages = val;
            return this;
        }

        public Builder status(WarehouseStatus status) {
            if (status != null) {
                this.status = status;
            }
            return this;
        }

        public Warehouse build() {
            if (this.warehouseId == null) {
                throw new WarehouseDomainException("WarehouseId must be set.");
            }
            if (this.name == null || this.name.trim().isEmpty()) {
                throw new WarehouseDomainException("Name must be set.");
            }
            if (this.location == null) {
                throw new WarehouseDomainException("Location must be set.");
            }
            return new Warehouse(this);
        }
    }
}
