package com.sokima.specification.rest.inventory.manage.v1.response;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("InventoryAllocationResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class InventoryAllocationResponse implements Serializable {
    private Long warehouseId;

    private Long inventoryId;

    private Long productId;

    private Boolean ok;

    public InventoryAllocationResponse() {
    }

    public InventoryAllocationResponse(Long warehouseId, Long inventoryId, Long productId, Boolean ok) {
        this.warehouseId = warehouseId;
        this.inventoryId = inventoryId;
        this.productId = productId;
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

    @JsonProperty("product_id")
    public Long getProductId() {
        return productId;
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

    @JsonSetter("product_id")
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @JsonSetter("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        InventoryAllocationResponse that = (InventoryAllocationResponse) o;

        if (!Objects.equals(this.warehouseId, that.warehouseId)) return false;
        if (!Objects.equals(this.inventoryId, that.inventoryId)) return false;
        return Objects.equals(this.productId, that.productId);
    }

    @Override
    public int hashCode() {
        int result = this.warehouseId != null ? this.warehouseId.hashCode() : 0;
        result = 31 * result + (this.inventoryId != null ? inventoryId.hashCode() : 0);
        result = 31 * result + (this.productId != null ? productId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InventoryAllocationResponse[warehouseId='");
        sb.append(warehouseId);
        sb.append("', ");
        sb.append("inventoryId='");
        sb.append(inventoryId);
        sb.append("', ");
        sb.append("productId='");
        sb.append(productId);
        sb.append("', ");
        sb.append("ok='");
        sb.append(ok);
        sb.append("']");
        return sb.toString();
    }
}
