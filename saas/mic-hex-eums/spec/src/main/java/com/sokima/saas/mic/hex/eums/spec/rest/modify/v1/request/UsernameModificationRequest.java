package com.sokima.saas.mic.hex.eums.spec.rest.modify.v1.request;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("UsernameModificationRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class UsernameModificationRequest implements Serializable {
    private String newUsername;

    public UsernameModificationRequest() {
    }

    public UsernameModificationRequest(String newUsername) {
        this.newUsername = newUsername;
    }

    @Valid
    @Size(min = 6, max = 20)
    @NotNull
    @NotBlank
    @JsonProperty("new_username")
    public String getNewUsername() {
        return newUsername;
    }

    @JsonSetter("new_username")
    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        UsernameModificationRequest that = (UsernameModificationRequest) o;

        return this.newUsername.equals(that.newUsername);
    }

    @Override
    public int hashCode() {
        return this.newUsername.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UsernameModificationRequest[");
        sb.append("newUsername='");
        sb.append(newUsername);
        sb.append("']");
        return sb.toString();
    }
}
