package com.sokima.saas.mic.hex.epcs.spec.rest.explore.v1.response;

import com.fasterxml.jackson.annotation.*;
import com.sokima.saas.mic.hex.epcs.domain.model.Product;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("SingleProductExplorationResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class SingleProductExplorationResponse implements Serializable {
    private Long productId;

    private Boolean ok;

    private Product product;

    public SingleProductExplorationResponse() {
    }

    public SingleProductExplorationResponse(Long productId, Boolean ok, Product product) {
        this.productId = productId;
        this.ok = ok;
        this.product = product;
    }

    @JsonProperty("product_id")
    public Long getProductId() {
        return productId;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonProperty("product")
    public Product getProduct() {
        return product;
    }

    @JsonSetter("product_id")
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @JsonSetter("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @JsonSetter("product")
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        SingleProductExplorationResponse that = (SingleProductExplorationResponse) o;

        return Objects.equals(this.productId, that.productId);
    }

    @Override
    public int hashCode() {
        return this.productId != null ? this.productId.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SingleProductExplorationResponse[");
        sb.append("productId='");
        sb.append(productId);
        sb.append("', ");
        sb.append("ok='");
        sb.append(ok);
        sb.append("', ");
        sb.append("product='");
        sb.append(product);
        sb.append("']");
        return sb.toString();
    }
}
