package com.sokima.specification.rest.inventory.manage.v1.response;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("InventorySupplementResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class InventorySupplementResponse implements Serializable {
    private Long warehouseId;

    private Long inventoryId;

    private Boolean ok;

    public InventorySupplementResponse() {
    }

    public InventorySupplementResponse(Long warehouseId, Long inventoryId, Boolean ok) {
        this.warehouseId = warehouseId;
        this.inventoryId = inventoryId;
        this.ok = ok;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        InventorySupplementResponse that = (InventorySupplementResponse) o;

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
        sb.append("InventorySupplementResponse[");
        sb.append("warehouseId='");
        sb.append(warehouseId);
        sb.append("', ");
        sb.append("inventoryId='");
        sb.append(inventoryId);
        sb.append("', ");
        sb.append("ok='");
        sb.append(ok);
        sb.append("']");
        return sb.toString();
    }
}
