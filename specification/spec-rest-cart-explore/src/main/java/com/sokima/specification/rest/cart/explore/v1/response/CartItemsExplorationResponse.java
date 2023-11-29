package com.sokima.specification.rest.cart.explore.v1.response;


import com.fasterxml.jackson.annotation.*;
import com.sokima.domain.pojo.Product;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("CartItemsExplorationResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CartItemsExplorationResponse implements Serializable {
    private Long cartId;

    private Boolean ok;

    private List<Product> products;

    public CartItemsExplorationResponse() {
    }

    public CartItemsExplorationResponse(Long cartId, Boolean ok, List<Product> products) {
        this.cartId = cartId;
        this.ok = ok;
        this.products = products;
    }

    @JsonProperty("cart_id")
    public Long getCartId() {
        return cartId;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonProperty("products")
    public List<Product> getProduct() {
        return products;
    }

    @JsonSetter("cart_id")
    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    @JsonSetter("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @JsonSetter("products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        CartItemsExplorationResponse that = (CartItemsExplorationResponse) o;

        if (!Objects.equals(this.cartId, that.cartId)) return false;
        return Objects.equals(this.products, that.products);
    }

    @Override
    public int hashCode() {
        int result = this.cartId != null ? this.cartId.hashCode() : 0;
        result = 31 * result + (this.products != null ? this.products.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartItemsExplorationResponse[");
        sb.append("cartId='");
        sb.append(cartId);
        sb.append("', ");
        sb.append("ok='");
        sb.append(ok);
        sb.append("', ");
        sb.append("products='");
        sb.append(products);
        sb.append("']");
        return sb.toString();
    }
}
