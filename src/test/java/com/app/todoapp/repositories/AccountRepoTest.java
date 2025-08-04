package com.app.todoapp.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.todoapp.models.Account;

@DataJpaTest
public class AccountRepoTest {
    //given - when - then

    @Autowired
    private AccountRepo accountRepo;
    Account account;

    @BeforeEach
    void setUp(){
        account = new Account();
        account.setUsername("User1");
        account.setPassword("Pass1");
        account.setRole("ADMIN");

        accountRepo.save(account);
    }

    @AfterEach
    void tearDown(){
        account = null;
        accountRepo.deleteAll();
    }


    //Test cases 

    //Success
    @Test
    void testfindByUsername_Found(){
       Optional<Account> found = accountRepo.findByUsername("User1");

       assertTrue(found.isPresent(), "Account should be present");
       assertEquals("User1", found.get().getUsername());
       assertEquals("Pass1", found.get().getPassword());
       assertEquals("ADMIN", found.get().getRole());

       System.out.println("Account found: " + found.get());
    }



    //Failure
    @Test
    void testFindByUsername_notFound(){
        Optional<Account> notFound = accountRepo.findByUsername("Uuseer");

        assertFalse(notFound.isPresent(), "Account should not be found");

        System.out.println("Account not found");
    }
}
