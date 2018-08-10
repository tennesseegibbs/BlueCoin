package com.buecoin01.controller;

import com.buecoin01.Repositories.TransactionRepository;
import com.buecoin01.Repositories.WalletRepository;
import com.buecoin01.model.Transactions;
import com.buecoin01.model.Wallet;
import com.buecoin01.utility.Encryption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConductTransactions {


    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletRepository walletRepository;

    private static final Logger logger = LoggerFactory.getLogger(ConductTransactions.class);



    public ResponseEntity transferMoney( Transactions transaction) {
       Wallet receiver = walletRepository.findWalletByPublicId(transaction.getToId()).get(0);

        Wallet sender = walletRepository.findWalletByPublicId(transaction.getFromId()).get(0);

           if (sender.getAmount() >= transaction.getAmount() && !sender.getPublicId().equals(receiver.getPublicId())) {

        logger.info("controller is hitting this method");
               sender.setAmount(sender.getAmount() - transaction.getAmount());
               walletRepository.save(sender);

               Double amount = receiver.getAmount();

               receiver.setAmount(amount + transaction.getAmount());
               walletRepository.save(receiver);

               Transactions n = new Transactions(Encryption.applySha256(sender.getPublicId() + receiver.getPublicId() + Double.toString(transaction.getAmount()) + LocalDateTime.now()),
                       transaction.getFromId(), transaction.getToId(), transaction.getAmount(), LocalDateTime.now());
               logger.info("got here");

               transactionRepository.save(n);
               logger.info("got here");

               return new ResponseEntity<>(transaction, HttpStatus.CREATED);
           } else {
               logger.info("bad request");
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           }


}




}
