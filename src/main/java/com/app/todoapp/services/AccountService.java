package com.app.todoapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public void registerUser(Account account){
        if(accountRepo.findByUsername(account.getUsername()).isPresent()){
            throw new RuntimeException("Username already exist");
        }

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole("USER");
        accountRepo.save(account);
    }

    //for jwt authentication - first check if user is authenticated, if so, create the jwt token and return
    public String getAccountInfo(Account account){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                account.getUsername(), account.getPassword()
            )
        );

        if(authentication.isAuthenticated())
            return jwtService.generateToken(account.getUsername());

        return "failure";
    }


}
