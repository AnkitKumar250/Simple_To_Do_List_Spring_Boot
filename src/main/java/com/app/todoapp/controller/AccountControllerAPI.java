package com.app.todoapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.todoapp.models.Account;
import com.app.todoapp.services.AccountService;

@RestController
@RequestMapping("/account/api")
public class AccountControllerAPI {
    private AccountService accountService;

    public AccountControllerAPI(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Account account){
        accountService.registerUser(account);
        return new ResponseEntity<>("User has been registered successfully", HttpStatus.CREATED);
    }

}
