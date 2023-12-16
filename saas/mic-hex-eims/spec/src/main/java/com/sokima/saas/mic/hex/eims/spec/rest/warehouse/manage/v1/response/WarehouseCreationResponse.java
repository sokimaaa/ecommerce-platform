package com.sokima.saas.mic.hex.eims.spec.rest.warehouse.manage.v1.response;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("WarehouseCreationResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class WarehouseCreationResponse implements Serializable {
    private Long warehouseId;

    private Boolean ok;

    public WarehouseCreationResponse() {
    }

    public WarehouseCreationResponse(Long warehouseId, Boolean ok) {
        this.warehouseId = warehouseId;
        this.ok = ok;
    }

    @JsonProperty("warehouse_id")
    public Long getWarehouseId() {
        return warehouseId;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonSetter("warehouse_id")
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    @JsonSetter("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        WarehouseCreationResponse that = (WarehouseCreationResponse) o;

        return Objects.equals(this.warehouseId, that.warehouseId);
    }

    @Override
    public int hashCode() {
        return this.warehouseId != null ? this.warehouseId.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WarehouseCreationResponse[");
        sb.append("warehouseId='");
        sb.append(warehouseId);
        sb.append("', ");
        sb.append("ok='");
        sb.append(ok);
        sb.append("']");
        return sb.toString();
    }
}
