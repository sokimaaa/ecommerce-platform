package com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.request;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("CartPuttingRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CartPuttingRequest implements Serializable {
    private Long productId;

    public CartPuttingRequest() {
    }

    public CartPuttingRequest(Long productId) {
        this.productId = productId;
    }

    @Valid
    @NotNull
    @JsonProperty("product_id")
    public Long getProductId() {
        return productId;
    }

    @JsonSetter("product_id")
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        CartPuttingRequest that = (CartPuttingRequest) o;

        return Objects.equals(this.productId, that.productId);
    }

    @Override
    public int hashCode() {
        return this.productId != null ? this.productId.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartPuttingRequest[productId='");
        sb.append(productId);
        sb.append("']");
        return sb.toString();
    }
}
