package com.atm.api.service;

import com.atm.api.model.Bank_account;
import com.atm.api.repository.Bank_account_repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BankAccountService {
    @Autowired
    private Bank_account_repository bankAccountRepository;

    public Bank_account getBankAccountByPasnummer(String pasnummer){
        Optional<Bank_account> bankAccount = bankAccountRepository.findByPasnummer(pasnummer);
        return bankAccount.orElse(null);
    }

    public BigDecimal getBalance(String pasnummer){
        Optional<Bank_account> bankAccount = bankAccountRepository.findByPasnummer(pasnummer);
        return bankAccount.map(Bank_account::getBalance).orElse(null);
    }



    @Transactional
    public void deductAmount(String pasnummer, BigDecimal amount) throws InsufficientFundsException, AccountNotFoundException {
        Optional<Bank_account> optionalAccount = bankAccountRepository.findByPasnummer(pasnummer);
        if (optionalAccount.isPresent()) {
            Bank_account account = optionalAccount.get();
            BigDecimal currentBalance = account.getBalance();
            if (currentBalance.compareTo(amount) >= 0) {
                BigDecimal newBalance = currentBalance.subtract(amount);
                account.setBalance(newBalance);
                bankAccountRepository.save(account);
            } else {
                throw new InsufficientFundsException("Not enough balance");
            }
        } else {
            throw new AccountNotFoundException("Account not found");
        }
    }

    // Custom exceptions
    public static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    public static class AccountNotFoundException extends Exception {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }
}
