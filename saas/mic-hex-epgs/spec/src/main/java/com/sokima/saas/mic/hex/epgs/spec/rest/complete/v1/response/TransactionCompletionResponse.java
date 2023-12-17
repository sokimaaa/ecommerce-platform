package com.sokima.saas.mic.hex.epgs.spec.rest.complete.v1.response;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("TransactionCompletionResponse")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class TransactionCompletionResponse implements Serializable {
    private Long transactionId;

    private Boolean ok;

    public TransactionCompletionResponse() {
    }

    public TransactionCompletionResponse(Long transactionId, Boolean ok) {
        this.transactionId = transactionId;
        this.ok = ok;
    }

    @JsonProperty("transaction_id")
    public Long getTransactionId() {
        return transactionId;
    }

    @JsonProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonSetter("transaction_id")
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @JsonSetter("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        TransactionCompletionResponse that = (TransactionCompletionResponse) o;

        return Objects.equals(this.transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return this.transactionId != null ? this.transactionId.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransactionCompletionResponse[");
        sb.append("transactionId='");
        sb.append(transactionId);
        sb.append("', ");
        sb.append("ok='");
        sb.append(ok);
        sb.append("']");
        return sb.toString();
    }
}
