package com.app.todoapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.todoapp.models.Account;
import com.app.todoapp.repositories.AccountRepo;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(Account account){
        if(accountRepo.findByUsername(account.getUsername()).isPresent()){
            throw new RuntimeException("Username already exist");
        }

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole("USER");
        accountRepo.save(account);
    }
}
