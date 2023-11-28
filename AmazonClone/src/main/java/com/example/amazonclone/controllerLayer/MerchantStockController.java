package com.example.amazonclone.controllerLayer;

import com.example.amazonclone.Service.MerchantStockService;
import com.example.amazonclone.modelLayer.MerchantStock;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merch")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;
    @GetMapping("/get")

    public ArrayList<MerchantStock> getMerchantStockService(){

        return merchantStockService.getMerchantStocks();
    }
    @PostMapping("/post")
    public ResponseEntity addMerchantStockService(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean add =merchantStockService.addMerchantStock(merchantStock);
        if (add) {
            return ResponseEntity.status(HttpStatus.OK).body("added merchantStock");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please check the portal");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateMerchantStockService(@PathVariable String id,@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        boolean az =merchantStockService.updateMerchantStock(merchantStock);
        if (az) {
            return ResponseEntity.status(HttpStatus.OK).body("Update merchantStock");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Value not available");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStockService(@PathVariable String id){
       boolean isDeleted= merchantStockService.deleteMerchantStock(id);
        if (isDeleted) {
            merchantStockService.deleteMerchantStock(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted merchantStock");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Value not available");
    }
    }
