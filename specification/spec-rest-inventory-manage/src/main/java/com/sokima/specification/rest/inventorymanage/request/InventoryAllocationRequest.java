package com.sokima.specification.rest.inventorymanage.request;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("InventoryAllocationRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class InventoryAllocationRequest implements Serializable {
    private String productName;

    private String productDescription;

    private Float instantProductPrice;

    private String category;

    private Integer instantQuantity;

    public InventoryAllocationRequest() {
    }

    public InventoryAllocationRequest(String productName, String productDescription, Float instantProductPrice, String category, Integer instantQuantity) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.instantProductPrice = instantProductPrice;
        this.category = category;
        this.instantQuantity = instantQuantity;
    }

    @Valid
    @NotNull
    @NotBlank
    @Size(min = 6, max = 20)
    @JsonProperty("product_name")
    public String getProductName() {
        return productName;
    }

    @Valid
    @NotNull
    @NotBlank
    @JsonProperty("product_description")
    public String getProductDescription() {
        return productDescription;
    }

    @Valid
    @NotNull
    @Positive
    @JsonProperty("instant_product_price")
    public Float getInstantProductPrice() {
        return instantProductPrice;
    }

    @Valid
    @NotNull
    @NotBlank
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @Valid
    @NotNull
    @Positive
    @JsonProperty("instant_quantity")
    public Integer getInstantQuantity() {
        return instantQuantity;
    }

    @JsonSetter("product_name")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonSetter("product_description")
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @JsonSetter("instant_product_price")
    public void setInstantProductPrice(Float instantProductPrice) {
        this.instantProductPrice = instantProductPrice;
    }

    @JsonSetter("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonSetter("instant_quantity")
    public void setInstantQuantity(Integer instantQuantity) {
        this.instantQuantity = instantQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        InventoryAllocationRequest that = (InventoryAllocationRequest) o;

        if (!Objects.equals(this.productName, that.productName)) return false;
        return Objects.equals(this.category, that.category);
    }

    @Override
    public int hashCode() {
        int result = this.productName != null ? this.productName.hashCode() : 0;
        result = 31 * result + (this.category != null ? this.category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InventoryAllocationRequest[productName='");
        sb.append(productName);
        sb.append("', ");
        sb.append("productDescription='");
        sb.append(productDescription);
        sb.append("', ");
        sb.append("instantProductPrice='");
        sb.append(instantProductPrice);
        sb.append("', ");
        sb.append("category='");
        sb.append(category);
        sb.append("', ");
        sb.append("instantQuantity='");
        sb.append(instantQuantity);
        sb.append("']");
        return sb.toString();
    }
}
