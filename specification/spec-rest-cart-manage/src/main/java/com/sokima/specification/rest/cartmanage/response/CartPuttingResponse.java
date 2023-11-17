package com.sokima.specification.rest.cartmanage.response;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("CartPuttingResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CartPuttingResponse implements Serializable {
    private Long cartId;

    private Long productId;

    private Boolean ok;

    public CartPuttingResponse() {
    }

    public CartPuttingResponse(Long cartId, Long productId, Boolean ok) {
        this.cartId = cartId;
        this.productId = productId;
        this.ok = ok;
    }

    @JsonProperty("cart_id")
    public Long getCartId() {
        return cartId;
    }

    @JsonProperty("product_id")
    public Long getProductId() {
        return productId;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonSetter("cart_id")
    public void setCartId(Long cartId) {
        this.cartId = cartId;
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

        CartPuttingResponse that = (CartPuttingResponse) o;

        if (!Objects.equals(this.cartId, that.cartId)) return false;
        return Objects.equals(this.productId, that.productId);
    }

    @Override
    public int hashCode() {
        int result = this.cartId != null ? this.cartId.hashCode() : 0;
        result = 31 * result + (this.productId != null ? this.productId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartPuttingResponse[");
        sb.append("cartId='");
        sb.append(cartId);
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
