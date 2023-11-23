package com.sokima.specification.rest.userauth.request;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("UserRegistrationRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserRegistrationRequest implements Serializable {
    private String username;

    private String role;

    private String email;

    private String password;

    public UserRegistrationRequest() {

    }

    public UserRegistrationRequest(String username, String role, String email, String password) {
        this.username = username;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    @Valid
    @Size(min = 6, max = 20)
    @NotNull
    @NotBlank
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @Valid
    @NotNull
    @NotBlank
    @JsonProperty("role")
    public String getRole() {
        return role;
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

    @JsonSetter("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonSetter("role")
    public void setRole(String role) {
        this.role = role;
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

        UserRegistrationRequest that = (UserRegistrationRequest) o;

        return this.email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return this.email.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserRegistrationRequest[");
        sb.append("username='");
        sb.append(username);
        sb.append("', ");
        sb.append("role='");
        sb.append(role);
        sb.append("', ");
        sb.append("email='");
        sb.append(email);
        sb.append("', ");
        sb.append("password='");
        sb.append("*****']");
        return sb.toString();
    }
}
