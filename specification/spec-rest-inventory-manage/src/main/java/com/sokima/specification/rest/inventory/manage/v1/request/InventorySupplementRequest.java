package com.sokima.specification.rest.inventory.manage.v1.request;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("InventorySupplementRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class InventorySupplementRequest implements Serializable {
    private Integer supplementQuantity;

    public InventorySupplementRequest() {
    }

    public InventorySupplementRequest(Integer supplementQuantity) {
        this.supplementQuantity = supplementQuantity;
    }

    @Valid
    @NotNull
    @Positive
    @JsonProperty("supplement_quantity")
    public Integer getSupplementQuantity() {
        return supplementQuantity;
    }

    @JsonSetter("supplement_quantity")
    public void setSupplementQuantity(Integer supplementQuantity) {
        this.supplementQuantity = supplementQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        InventorySupplementRequest that = (InventorySupplementRequest) o;

        return Objects.equals(this.supplementQuantity, that.supplementQuantity);
    }

    @Override
    public int hashCode() {
        return this.supplementQuantity != null ? this.supplementQuantity.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InventorySupplementRequest[supplementQuantity='");
        sb.append(supplementQuantity);
        sb.append("']");
        return sb.toString();
    }
}
