package com.sokima.specification.rest.cartmanage.response;


import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("CartCleanerResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CartCleanerResponse implements Serializable {
    private Long cartId;

    private List<Long> cleanedProductIds;

    private Boolean ok;

    public CartCleanerResponse() {
    }

    public CartCleanerResponse(Long cartId, List<Long> cleanedProductIds, Boolean ok) {
        this.cartId = cartId;
        this.cleanedProductIds = cleanedProductIds;
        this.ok = ok;
    }

    @JsonProperty("cart_id")
    public Long getCartId() {
        return cartId;
    }

    @JsonProperty("cleaned_product_ids")
    public List<Long> getCleanedProductIds() {
        return cleanedProductIds;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonSetter("cart_id")
    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    @JsonSetter("cleaned_product_ids")
    public void setCleanedProductIds(List<Long> cleanedProductIds) {
        this.cleanedProductIds = cleanedProductIds;
    }

    @JsonSetter("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        CartCleanerResponse that = (CartCleanerResponse) o;

        if (!Objects.equals(this.cartId, that.cartId)) return false;
        return Objects.equals(this.cleanedProductIds, that.cleanedProductIds);
    }

    @Override
    public int hashCode() {
        int result = this.cartId != null ? this.cartId.hashCode() : 0;
        result = 31 * result + (this.cleanedProductIds != null ? this.cleanedProductIds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartCleanerResponse[");
        sb.append("cartId='");
        sb.append(cartId);
        sb.append("', ");
        sb.append("cleanedProductIds='");
        sb.append(cleanedProductIds);
        sb.append("', ");
        sb.append("ok='");
        sb.append(ok);
        sb.append("']");
        return sb.toString();
    }
}
