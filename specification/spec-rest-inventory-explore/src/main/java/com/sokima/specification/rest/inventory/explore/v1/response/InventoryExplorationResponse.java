package com.sokima.specification.rest.inventory.explore.v1.response;

import com.fasterxml.jackson.annotation.*;
import com.sokima.domain.model.pojo.Inventory;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("InventoryExplorationResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class InventoryExplorationResponse implements Serializable {
    private Long warehouseId;

    private Long inventoryId;

    private Boolean ok;

    private Inventory inventory;

    public InventoryExplorationResponse() {
    }

    public InventoryExplorationResponse(Long warehouseId, Long inventoryId, Boolean ok, Inventory inventory) {
        this.warehouseId = warehouseId;
        this.inventoryId = inventoryId;
        this.ok = ok;
        this.inventory = inventory;
    }

    @JsonProperty("warehouse_id")
    public Long getWarehouseId() {
        return warehouseId;
    }

    @JsonProperty("inventory_id")
    public Long getInventoryId() {
        return inventoryId;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonProperty("inventory")
    public Inventory getInventory() {
        return inventory;
    }

    @JsonSetter("warehouse_id")
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    @JsonSetter("inventory_id")
    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    @JsonSetter("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @JsonSetter("inventory")
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        InventoryExplorationResponse that = (InventoryExplorationResponse) o;

        if (!Objects.equals(this.warehouseId, that.warehouseId)) return false;
        return Objects.equals(this.inventoryId, that.inventoryId);
    }

    @Override
    public int hashCode() {
        int result = this.warehouseId != null ? this.warehouseId.hashCode() : 0;
        result = 31 * result + (this.inventoryId != null ? this.inventoryId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InventoryExplorationResponse[");
        sb.append("warehouseId='");
        sb.append(warehouseId);
        sb.append("', ");
        sb.append("inventoryId='");
        sb.append(inventoryId);
        sb.append("', ");
        sb.append("ok='");
        sb.append(ok);
        sb.append("', ");
        sb.append("inventory='");
        sb.append(inventory);
        sb.append("']");
        return sb.toString();
    }
}
