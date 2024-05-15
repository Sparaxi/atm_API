package com.atm.api.DTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

public class BalanceDTO {
    public static class BalanceResponse {
        private BigDecimal balance;

        public BalanceResponse(BigDecimal balance) {
            this.balance = balance;
        }

        // Getter
        public BigDecimal getBalance() {
            return balance;
        }

        // Setter is optional depending on whether you want to allow modification
        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }
    }
}
