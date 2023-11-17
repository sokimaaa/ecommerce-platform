package com.sokima.specification.rest.productmodify.request;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("DescriptionModificationRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class DescriptionModificationRequest implements Serializable {
    private String newDescription;

    public DescriptionModificationRequest() {
    }

    public DescriptionModificationRequest(String newDescription) {
        this.newDescription = newDescription;
    }

    @Valid
    @NotNull
    @NotBlank
    @JsonProperty("new_description")
    public String getNewDescription() {
        return newDescription;
    }

    @JsonSetter("new_description")
    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        DescriptionModificationRequest that = (DescriptionModificationRequest) o;

        return this.newDescription.equals(that.newDescription);
    }

    @Override
    public int hashCode() {
        return this.newDescription.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DescriptionModificationRequest[newDescription='");
        sb.append(newDescription);
        sb.append("']");
        return sb.toString();
    }
}
