package com.atm.api.service;

import com.atm.api.model.Bank_account;
import com.atm.api.repository.Bank_account_repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean deductAmount(String pasnummer, BigDecimal amount){
        Optional<Bank_account> optionalAccount = bankAccountRepository.findByPasnummer(pasnummer);
        if (optionalAccount.isPresent()) {
            Bank_account account = optionalAccount.get(); // Correctly retrieve the Bank_account instance
            BigDecimal currentBalance = account.getBalance(); // Now you can call getBalance()
            if(currentBalance.compareTo(amount) >= 0 ){
                BigDecimal newBalance = currentBalance.subtract(amount);
                account.setBalance(newBalance);
                bankAccountRepository.save(account);
                return true; // Success, amount deducted
            }
        }
        return false; // Failure, amount not deducted due to insufficient funds or account not found
    }
}
