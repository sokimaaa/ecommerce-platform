package com.sokima.specification.rest.warehousemanage.request;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("WarehouseCreationRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class WarehouseCreationRequest implements Serializable {
    private String address;

    public WarehouseCreationRequest() {
    }

    public WarehouseCreationRequest(String address) {
        this.address = address;
    }

    @Valid
    @NotNull
    @NotBlank
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonSetter("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        WarehouseCreationRequest that = (WarehouseCreationRequest) o;

        return this.address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return this.address.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WarehouseCreationRequest[address='");
        sb.append(address);
        sb.append("']");
        return sb.toString();
    }
}
