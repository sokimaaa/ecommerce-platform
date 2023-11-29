package com.sokima.specification.rest.product.modify.v1.response;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("DescriptionModificationResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class DescriptionModificationResponse implements Serializable {
    private Long productId;

    private Boolean ok;

    public DescriptionModificationResponse() {
    }

    public DescriptionModificationResponse(Long productId, Boolean ok) {
        this.productId = productId;
        this.ok = ok;
    }

    @JsonProperty("product_id")
    public Long getProductId() {
        return productId;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
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

        DescriptionModificationResponse that = (DescriptionModificationResponse) o;

        return Objects.equals(this.productId, that.productId);
    }

    @Override
    public int hashCode() {
        return this.productId != null ? this.productId.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DescriptionModificationResponse[");
        sb.append("productId='");
        sb.append(productId);
        sb.append("', ");
        sb.append("ok='");
        sb.append(ok);
        sb.append("']");
        return sb.toString();
    }
}
