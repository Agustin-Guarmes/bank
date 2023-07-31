package com.gyl.bank.entities;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class SavingsAccount extends Account {
    private BigDecimal interestRate;

    public SavingsAccount() {
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}