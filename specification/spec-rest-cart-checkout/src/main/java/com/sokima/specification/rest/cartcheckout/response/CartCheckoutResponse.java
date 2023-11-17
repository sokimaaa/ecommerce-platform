package com.sokima.specification.rest.cartcheckout.response;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("CartCheckoutResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CartCheckoutResponse implements Serializable {
    private Long cartId;

    private Long transactionId;

    private Long orderId;

    private Boolean ok;

    public CartCheckoutResponse() {
    }

    public CartCheckoutResponse(Long cartId, Long transactionId, Long orderId, Boolean ok) {
        this.cartId = cartId;
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.ok = ok;
    }

    @JsonProperty("cart_id")
    public Long getCartId() {
        return cartId;
    }

    @JsonProperty("transaction_id")
    public Long getTransactionId() {
        return transactionId;
    }

    @JsonProperty("order_id")
    public Long getOrderId() {
        return orderId;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonSetter("cart_id")
    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    @JsonSetter("transaction_id")
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @JsonSetter("order_id")
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @JsonSetter("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        CartCheckoutResponse that = (CartCheckoutResponse) o;

        if (!Objects.equals(this.cartId, that.cartId)) return false;
        if (!Objects.equals(this.transactionId, that.transactionId))
            return false;
        return Objects.equals(this.orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        int result = this.cartId != null ? this.cartId.hashCode() : 0;
        result = 31 * result + (this.transactionId != null ? this.transactionId.hashCode() : 0);
        result = 31 * result + (this.orderId != null ? this.orderId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartCheckoutResponse[");
        sb.append("cartId='");
        sb.append(cartId);
        sb.append("', ");
        sb.append("transactionId='");
        sb.append(transactionId);
        sb.append("', ");
        sb.append("orderId='");
        sb.append(orderId);
        sb.append("', ");
        sb.append("ok='");
        sb.append(ok);
        sb.append("']");
        return sb.toString();
    }
}
