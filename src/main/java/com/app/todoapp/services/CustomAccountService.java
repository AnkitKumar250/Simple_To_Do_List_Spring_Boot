package com.app.todoapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.todoapp.models.Account;
import com.app.todoapp.repositories.AccountRepo;

@Service
public class CustomAccountService implements UserDetailsService{

    @Autowired 
    private AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Account account = accountRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        
        return new org.springframework.security.core.userdetails.User(
            account.getUsername(),
            account.getPassword(),
            List.of(new SimpleGrantedAuthority("ROLE_" + account.getRole()))
        );
    }
}
