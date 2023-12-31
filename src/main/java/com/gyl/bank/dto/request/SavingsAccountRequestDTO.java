package com.gyl.bank.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

    public class SavingsAccountRequestDTO {
        @Size(min = 10, max = 10, message = "El número de cuenta debe tener 10 dígitos.")
        private String accountNumber;

        @NotNull(message = "Se debe ingresar un id de cliente válido.")
        private String clientId;

        @PositiveOrZero(message = "El saldo no puede ser negativo.")
        private BigDecimal balance;

        @Positive(message = "La tasa de interés debe ser un número positivo.")
        private BigDecimal interestRate;

        public SavingsAccountRequestDTO() {
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

        public BigDecimal getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(BigDecimal interestRate) {
            this.interestRate = interestRate;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }
    }