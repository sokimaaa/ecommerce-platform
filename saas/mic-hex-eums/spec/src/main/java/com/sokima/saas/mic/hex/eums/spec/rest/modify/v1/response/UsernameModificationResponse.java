package com.sokima.saas.mic.hex.eums.spec.rest.modify.v1.response;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("UsernameModificationResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class UsernameModificationResponse implements Serializable {
    private Long userId;

    private Boolean ok;

    public UsernameModificationResponse() {
    }

    public UsernameModificationResponse(Long userId, Boolean ok) {
        this.userId = userId;
        this.ok = ok;
    }

    @JsonProperty("user_id")
    public Long getUserId() {
        return userId;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonSetter("user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @JsonSetter("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        UsernameModificationResponse that = (UsernameModificationResponse) o;

        return Objects.equals(this.userId, that.userId);
    }

    @Override
    public int hashCode() {
        return this.userId != null ? this.userId.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UsernameModificationResponse[");
        sb.append("userId='");
        sb.append(userId);
        sb.append("', ");
        sb.append("ok='");
        sb.append(ok);
        sb.append("']");
        return sb.toString();
    }
}
