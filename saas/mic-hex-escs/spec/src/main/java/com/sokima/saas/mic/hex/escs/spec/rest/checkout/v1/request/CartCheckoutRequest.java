package com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.request;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("CartCheckoutRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CartCheckoutRequest implements Serializable {
    private String shippingAddress;

    private String paymentMethod;

    public CartCheckoutRequest() {
    }

    public CartCheckoutRequest(String shippingAddress, String paymentMethod) {
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
    }

    @Valid
    @NotNull
    @NotBlank
    @JsonProperty("shipping_address")
    public String getShippingAddress() {
        return shippingAddress;
    }

    @Valid
    @NotNull
    @NotBlank
    @JsonProperty("payment_method")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    @JsonSetter("shipping_address")
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @JsonSetter("payment_method")
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        CartCheckoutRequest that = (CartCheckoutRequest) o;

        if (!Objects.equals(this.shippingAddress, that.shippingAddress))
            return false;
        return Objects.equals(this.paymentMethod, that.paymentMethod);
    }

    @Override
    public int hashCode() {
        int result = this.shippingAddress != null ? this.shippingAddress.hashCode() : 0;
        result = 31 * result + (this.paymentMethod != null ? this.paymentMethod.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartCheckoutRequest[shippingAddress='");
        sb.append(shippingAddress);
        sb.append("', ");
        sb.append("paymentMethod='");
        sb.append(paymentMethod);
        sb.append("']");
        return sb.toString();
    }
}
