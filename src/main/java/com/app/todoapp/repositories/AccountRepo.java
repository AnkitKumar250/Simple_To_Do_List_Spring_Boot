package com.app.todoapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.todoapp.models.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{
    Optional<Account> findByUsername(String username);
}
