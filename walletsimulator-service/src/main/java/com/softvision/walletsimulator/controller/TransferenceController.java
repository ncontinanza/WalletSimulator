package com.softvision.walletsimulator.controller;

import com.softvision.walletsimulator.domain.service.TransferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transfer")
public class TransferenceController {

    private TransferenceService transferenceService;

    @Autowired
    public TransferenceController(TransferenceService transferenceService) {
        this.transferenceService = transferenceService;
    }

    @PostMapping
    public ResponseEntity<String> transfer() {
        return ResponseEntity.ok(HttpStatus.OK.toString());
    }



}
