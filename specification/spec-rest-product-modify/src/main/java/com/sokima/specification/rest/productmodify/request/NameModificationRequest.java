package com.sokima.specification.rest.productmodify.request;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("NameModificationRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class NameModificationRequest implements Serializable {
    private String newName;

    public NameModificationRequest() {
    }

    public NameModificationRequest(String newName) {
        this.newName = newName;
    }

    @Valid
    @Size(min = 6, max = 20)
    @NotNull
    @NotBlank
    @JsonProperty("new_name")
    public String getNewName() {
        return newName;
    }

    @JsonSetter("new_name")
    public void setNewName(String newName) {
        this.newName = newName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        NameModificationRequest that = (NameModificationRequest) o;

        return this.newName.equals(that.newName);
    }

    @Override
    public int hashCode() {
        return this.newName.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NameModificationRequest[newName='");
        sb.append(newName);
        sb.append("']");
        return sb.toString();
    }
}
