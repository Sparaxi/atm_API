package com.atm.api.DTO;

import java.math.BigDecimal;

public class AmountDTO {
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}