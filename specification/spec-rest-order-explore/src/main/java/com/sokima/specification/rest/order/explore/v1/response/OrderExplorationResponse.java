package com.sokima.specification.rest.order.explore.v1.response;

import com.fasterxml.jackson.annotation.*;
import com.sokima.domain.model.pojo.Order;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("OrderExplorationResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class OrderExplorationResponse implements Serializable {
    private Long orderId;

    private Boolean ok;

    private Order order;

    public OrderExplorationResponse() {

    }

    public OrderExplorationResponse(Long orderId, Boolean ok, Order order) {
        this.orderId = orderId;
        this.ok = ok;
        this.order = order;
    }

    @JsonProperty("order_id")
    public Long getOrderId() {
        return orderId;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonProperty("order")
    public Order getOrder() {
        return order;
    }

    @JsonSetter("order_id")
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @JsonSetter("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @JsonSetter("order")
    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        OrderExplorationResponse that = (OrderExplorationResponse) o;

        return Objects.equals(this.orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return this.orderId != null ? this.orderId.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderExplorationResponse[");
        sb.append("orderId='");
        sb.append(orderId);
        sb.append("', ");
        sb.append("ok='");
        sb.append(ok);
        sb.append("', ");
        sb.append("order='");
        sb.append(order);
        sb.append("']");
        return sb.toString();
    }
}
