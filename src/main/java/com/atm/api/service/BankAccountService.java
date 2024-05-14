package com.atm.api.service;

import com.atm.api.model.Bank_account;
import com.atm.api.repository.Bank_account_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountService {
    @Autowired
    private Bank_account_repository bankAccountRepository;

    public Bank_account getBankAccountByPasnummer(String pasnummer){
        Optional<Bank_account> bankAccount = bankAccountRepository.findByPasnummer(pasnummer);
        return bankAccount.orElse(null);
    }

}
