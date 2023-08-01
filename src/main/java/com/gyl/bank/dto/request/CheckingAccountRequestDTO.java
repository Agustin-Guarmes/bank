package com.gyl.bank.dto.request;


import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CheckingAccountRequestDTO {
    @Size(min = 10, max = 10, message = "El número de cuenta debe tener 10 dígitos.")
    private String accountNumber;

    @PositiveOrZero(message = "El saldo no puede ser negativo.")
    private BigDecimal balance;

    @PositiveOrZero(message = "El límite de crédito no puede ser negativo.")
    private BigDecimal creditLimit;

    public CheckingAccountRequestDTO() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
