package com.buecoin01;

import com.buecoin01.Repositories.BlockRepository;
import com.buecoin01.Repositories.WalletRepository;

import com.buecoin01.controller.ConductTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.security.Security;
import java.time.LocalDateTime;

@Component
public class ProcessLoader implements ApplicationRunner {


    @Autowired
    WalletRepository repo1;

    @Autowired
    BlockRepository repo3;

    @Autowired
    ConductTransactions transaction;


    @Override
    public void run(ApplicationArguments args) {


    }
}
