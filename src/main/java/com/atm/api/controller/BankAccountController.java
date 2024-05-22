package com.atm.api.controller;

import com.atm.api.DTO.AmountDTO;
import com.atm.api.model.Bank_account;
import com.atm.api.service.BankAccountService;
import com.atm.api.DTO.BalanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/account")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/balance/{pasnummer}")
    public BalanceDTO.BalanceResponse getBalance(@PathVariable String pasnummer){
        BigDecimal balance = bankAccountService.getBalance(pasnummer);
        return new BalanceDTO.BalanceResponse(balance);
    }


    @GetMapping("/pasnummer/{pasnummer}")
    public Bank_account getBankAccountByPasnummer(@PathVariable String pasnummer) {
        return bankAccountService.getBankAccountByPasnummer(pasnummer);
    }

    @PostMapping("/deduct/{pasnummer}")
    public ResponseEntity<String> deductFromAccount(@PathVariable String pasnummer, @RequestBody AmountDTO amountDTO) {
        try {
            bankAccountService.deductAmount(pasnummer, amountDTO.getAmount());
            return new ResponseEntity<>("Amount deducted successfully", HttpStatus.OK);
        } catch (BankAccountService.InsufficientFundsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (BankAccountService.AccountNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}