package com.atm.api.repository;

import com.atm.api.model.Bank_account;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface Bank_account_repository extends JpaRepository<Bank_account, Integer> {


    Optional<Bank_account> findByPasnummer(String pasnummer);




}
