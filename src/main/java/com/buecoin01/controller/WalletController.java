package com.buecoin01.controller;

import com.buecoin01.Repositories.WalletRepository;
import com.buecoin01.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
public class WalletController {


        @Autowired
        private WalletRepository walletRepository;

        @RequestMapping(value = "/wallet/{id}", method = RequestMethod.GET)
        public ResponseEntity get(@PathVariable Long id) {
            Optional<Wallet> wallet = walletRepository.findById(id);
            return new ResponseEntity<>(wallet, HttpStatus.OK);

        }

        @RequestMapping(value = "/wallets", method = RequestMethod.GET)
        public ResponseEntity<Iterable<Wallet>> getAllUsers() {
            Iterable<Wallet> allWallets = walletRepository.findAll();
            return new ResponseEntity<>(allWallets, HttpStatus.OK);

        }

        @RequestMapping(path = "/addWallet", method = RequestMethod.POST)
        public ResponseEntity<?> create(@RequestBody Wallet wallet) {
            walletRepository.save(wallet);
            return new ResponseEntity<>(wallet, HttpStatus.CREATED);
        }

        @RequestMapping(path = "/deleteWallet", method = RequestMethod.DELETE)
        public ResponseEntity<Wallet> deleteWallet(@RequestBody Wallet wallet) {
            walletRepository.delete(wallet);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @RequestMapping(path = "/updateWallet", method = RequestMethod.PUT)
        public ResponseEntity<Wallet> updateWallet(@RequestBody Wallet wallet) {
            walletRepository.save(wallet);
            return new ResponseEntity<>(HttpStatus.OK);
        }




    }



