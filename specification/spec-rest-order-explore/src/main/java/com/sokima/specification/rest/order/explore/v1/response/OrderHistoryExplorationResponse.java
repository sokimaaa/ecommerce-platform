package com.sokima.specification.rest.order.explore.v1.response;

import com.fasterxml.jackson.annotation.*;
import com.sokima.domain.model.pojo.Order;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("OrderHistoryExplorationResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class OrderHistoryExplorationResponse implements Serializable {
    private Boolean ok;

    private List<Order> orders;

    public OrderHistoryExplorationResponse() {
    }

    public OrderHistoryExplorationResponse(Boolean ok, List<Order> orders) {
        this.ok = ok;
        this.orders = orders;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonProperty("orders")
    public List<Order> getOrders() {
        return orders;
    }

    @JsonSetter("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @JsonSetter("orders")
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        OrderHistoryExplorationResponse that = (OrderHistoryExplorationResponse) o;

        return Objects.equals(this.orders, that.orders);
    }

    @Override
    public int hashCode() {
        return this.orders != null ? this.orders.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderHistoryExplorationResponse[");
        sb.append("ok='");
        sb.append(ok);
        sb.append("', ");
        sb.append("orders='");
        sb.append(orders);
        sb.append("']");
        return sb.toString();
    }
}
