package com.sokima.saas.mic.hex.eums.spec.rest.auth.v1.request;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("UserAuthenticationRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserAuthRequest implements Serializable {
    private String email;

    private String password;

    public UserAuthRequest() {
    }

    public UserAuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Valid
    @NotNull
    @NotBlank
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @Valid
    @Size(min = 6, max = 20)
    @NotNull
    @NotBlank
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonSetter("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonSetter("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        UserAuthRequest that = (UserAuthRequest) o;

        return this.email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return this.email.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserAuthRequest[");
        sb.append("email='");
        sb.append(email);
        sb.append("', ");
        sb.append("password='");
        sb.append("*****']");
        return sb.toString();
    }
}
