package com.sokima.specification.rest.product.explore.v1.response;

import com.fasterxml.jackson.annotation.*;
import com.sokima.domain.pojo.Product;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("MultipleProductExplorationResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class MultipleProductExplorationResponse implements Serializable {
    private Boolean ok;

    private List<Product> products;

    public MultipleProductExplorationResponse() {
    }

    public MultipleProductExplorationResponse(Boolean ok, List<Product> products) {
        this.ok = ok;
        this.products = products;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonProperty("products")
    public List<Product> getProduct() {
        return products;
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

        MultipleProductExplorationResponse that = (MultipleProductExplorationResponse) o;

        return Objects.equals(this.products, that.products);
    }

    @Override
    public int hashCode() {
        return this.products != null ? this.products.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MultipleProductExplorationResponse[");
        sb.append("ok='");
        sb.append(ok);
        sb.append("', ");
        sb.append("products='");
        sb.append(products);
        sb.append("']");
        return sb.toString();
    }
}
