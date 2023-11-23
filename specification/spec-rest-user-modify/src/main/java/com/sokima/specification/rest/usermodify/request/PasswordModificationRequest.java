package com.sokima.specification.rest.usermodify.request;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("PasswordModificationRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class PasswordModificationRequest implements Serializable {
    private String newPassword;

    public PasswordModificationRequest() {

    }

    public PasswordModificationRequest(String newPassword) {
        this.newPassword = newPassword;
    }

    @Valid
    @Size(min = 6, max = 20)
    @NotNull
    @NotBlank
    @JsonProperty("new_password")
    public String getNewPassword() {
        return newPassword;
    }

    @JsonSetter("new_password")
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        PasswordModificationRequest that = (PasswordModificationRequest) o;

        return this.newPassword.equals(that.newPassword);
    }

    @Override
    public int hashCode() {
        return this.newPassword.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PasswordModificationRequest[newPassword='*****']");
        return sb.toString();
    }
}
