package com.sokima.specification.rest.productmodify.request;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("PriceModificationRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class PriceModificationRequest implements Serializable {
    private Float newPrice;

    public PriceModificationRequest() {
    }

    public PriceModificationRequest(Float newPrice) {
        this.newPrice = newPrice;
    }

    @Valid
    @NotNull
    @Positive
    @JsonProperty("new_price")
    public Float getNewPrice() {
        return newPrice;
    }

    @JsonSetter("new_price")
    public void setNewPrice(Float newPrice) {
        this.newPrice = newPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        PriceModificationRequest that = (PriceModificationRequest) o;

        return this.newPrice.equals(that.newPrice);
    }

    @Override
    public int hashCode() {
        return this.newPrice.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PriceModificationRequest[newPrice='");
        sb.append(newPrice);
        sb.append("']");
        return sb.toString();
    }
}
