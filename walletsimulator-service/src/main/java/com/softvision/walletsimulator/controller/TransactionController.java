package com.softvision.walletsimulator.controller;

import com.softvision.walletsimulator.api.model.Wallet;
import com.softvision.walletsimulator.domain.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path="/transfer")
    public ResponseEntity<String> transfer() {
        return ResponseEntity.ok(HttpStatus.OK.toString());
    }

    @PostMapping(path="/buy")
    public ResponseEntity<Wallet> buyCurrency() { return null; }



}
