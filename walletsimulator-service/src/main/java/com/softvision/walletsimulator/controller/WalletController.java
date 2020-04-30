package com.softvision.walletsimulator.controller;

import com.softvision.walletsimulator.api.model.Transference;
import com.softvision.walletsimulator.api.model.Wallet;
import com.softvision.walletsimulator.domain.service.WalletService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Optional;

@RestController
@RequestMapping("/wallet")
@Api(value = "/wallet", tags = { "Wallet" })
public class WalletController {
    private WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }

    @ApiOperation(value = "createWallet", notes = "Creates a new wallet",
            response = Wallet.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "walletName", value = "The desired name for the wallet",
            required = true, dataType = "String", paramType = "path")
    })
    @PostMapping(value="/{walletName}")
    public ResponseEntity<Wallet> createWallet(@PathVariable String walletName, @RequestBody(required = false) LinkedHashMap<String,Double> initialValues) {
        LinkedHashMap<String,Double> available = Optional.ofNullable(initialValues).orElse(new LinkedHashMap<>());
        return ResponseEntity.ok(walletService.createWallet(walletName, available));
    }

    @ApiOperation(value = "getWallet", notes = "Retrieves a wallet",
            response = Wallet.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "walletId", value = "The wallet Id to retrieve",
                    required = true, dataType = "String", paramType = "path")
    })
    @GetMapping(value="/{walletId}")
    public ResponseEntity<Wallet> getWallet(@PathVariable Integer walletId) {
        // TODO: try to make id a Long variable.
        return ResponseEntity.ok(walletService.getWalletById(walletId));
    }

    @ApiOperation(value = "updateWallet", notes = "Updates a wallet",
            response = Wallet.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "walletId", value = "The wallet Id to update",
            required = true, dataType = "String", paramType = "path")
    })
    @PutMapping(value="/{walletId}")
    public ResponseEntity<Wallet> updateWallet(@PathVariable Integer walletId, @RequestBody Wallet updatedWallet) {
        return ResponseEntity.ok(walletService.updateWallet(walletId, updatedWallet));
    }

    @ApiOperation(value = "deleteWallet", notes = "Deletes a wallet",
            response = Wallet.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "walletId", value = "The wallet Id to delete",
            required = true, dataType = "String", paramType = "path")
    })
    @DeleteMapping(value="/{walletId}")
    public ResponseEntity<Wallet> removeWallet(@PathVariable Integer walletId) {
        return ResponseEntity.ok(walletService.removeWallet(walletId));
    }

    @ApiOperation(value = "transfer", notes = "Transference between two wallets",
            response = String.class)
    @PostMapping(path="/transfer")
    public ResponseEntity<String> transfer(@RequestBody Transference transference) {
        walletService.transfer(transference);
        return ResponseEntity.ok(HttpStatus.OK.toString());
    }

    @ApiOperation(value = "buy", notes = "Purchase currency for a wallet",
            response = Wallet.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "walletId", value = "The id of the wallet which will make a purchase",
            required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "currency", value = "The currency of the operation",
                    required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "amount", value = "The amount to buy",
                    required = true, dataType = "String", paramType = "path")
    })
    @PostMapping(path="/buy")
    public ResponseEntity<Wallet> buyCurrency(Integer walletId, String currency, Double amount) { return null; }

}
