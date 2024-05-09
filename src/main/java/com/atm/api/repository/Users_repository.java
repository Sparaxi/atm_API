package com.atm.api.repository;

import com.atm.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users_repository extends JpaRepository <User, Integer>{

}
