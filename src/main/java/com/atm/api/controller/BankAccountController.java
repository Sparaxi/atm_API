package com.atm.api.controller;


import com.atm.api.model.Bank_account;
import com.atm.api.repository.Bank_account_repository;
import com.atm.api.repository.UserRepository;
import com.atm.api.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/pasnummer/{pasnummer}")
    public Bank_account getBankAccountByPasnummer(@PathVariable String pasnummer){
        return bankAccountService.getBankAccountByPasnummer(pasnummer);
    }


}
