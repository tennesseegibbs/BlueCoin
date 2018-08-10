package com.buecoin01.controller;

import com.buecoin01.Repositories.TransactionRepository;
import com.buecoin01.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
@RestController
public class TransactionController {

        private ConductTransactions conduct;
        private TransactionRepository transactionRepository;

        @Autowired
        public TransactionController(TransactionRepository transactionRepository, ConductTransactions conductTransactions) {
            this.conduct = conductTransactions;
            this.transactionRepository = transactionRepository;
        }

        @RequestMapping(value = "/transactions/{id}", method = RequestMethod.GET)
        public ResponseEntity get(@PathVariable Long id) {
            Optional<Transactions> transaction = transactionRepository.findById(id);
            return new ResponseEntity <>(transaction, HttpStatus.OK );

        }

        @RequestMapping(value = "/transactions", method = RequestMethod.GET)
        public ResponseEntity <Iterable <Transactions>> getAllUsers() {
            Iterable <Transactions> allTransactions = transactionRepository.findAll(sortByTimestampDesc());
            return new ResponseEntity <>( allTransactions, HttpStatus.OK );

        }

        private Sort sortByTimestampDesc() {
        return new Sort(Sort.Direction.DESC, "timestamp");
        }

        @RequestMapping(path = "/checkTx", method = RequestMethod.POST)
        public ResponseEntity <Transactions> create(@RequestBody Transactions transactions) {
            return conduct.transferMoney(transactions);
            //return new ResponseEntity <>(transactions, HttpStatus.CREATED );
        }

        @RequestMapping(path = "/deleteTx/{id}", method = RequestMethod.DELETE)
        public ResponseEntity <Transactions> deleteUser(@RequestBody Transactions transactions) {
            transactionRepository.delete(transactions);
            return new ResponseEntity <>( HttpStatus.OK );
        }

        @RequestMapping(path = "/updateTransaction", method = RequestMethod.PUT)
        public ResponseEntity <Transactions> updateUser(@RequestBody Transactions transactions) {
            transactionRepository.save(transactions);
            return new ResponseEntity <>( HttpStatus.OK );
        }



    }

