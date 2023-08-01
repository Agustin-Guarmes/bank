package com.gyl.bank.entities;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class CheckingAccount extends Account {
    private BigDecimal creditLimit;

    public CheckingAccount() {
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}