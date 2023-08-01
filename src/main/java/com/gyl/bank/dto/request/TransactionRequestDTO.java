package com.gyl.bank.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TransactionRequestDTO {
    @NotEmpty(message = "El id de la cuenta de origen no puede estar vacío.")
    private String fromAccountId;

    @NotEmpty(message = "El id de la cuenta de destino no puede estar vacío.")
    private String toAccountId;

    @Positive(message = "El monto de la transacción debe ser un número positivo.")
    private BigDecimal amount;

    public TransactionRequestDTO() {
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(String toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
