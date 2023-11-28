package com.example.amazonclone.controllerLayer;

import com.example.amazonclone.Service.MerchantService;
import com.example.amazonclone.modelLayer.Merchant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;
    @GetMapping("/get")
    public ArrayList<Merchant> getMerchant(){
        return merchantService.getMerchants();
    }
    @PostMapping("/post")
    public ResponseEntity addMerchant(@RequestBody Merchant merchant , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        merchantService.addMerchants(merchant);
        return ResponseEntity.status(HttpStatus.OK).body("Added Merchant");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateMerchant(@PathVariable String id,@RequestBody Merchant merchant , Errors errors){
        if (errors.hasErrors()){
            String message1 = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message1);
        }
        merchantService.updateMerchants(id,merchant);
        return ResponseEntity.status(HttpStatus.OK).body("Update Merchant");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable String id){
        boolean isDelete =merchantService.deleteMerchants(id);
        if (isDelete) {
            merchantService.deleteMerchants(id);
            return ResponseEntity.status(HttpStatus.OK).body("Delete Merchant");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter id true");

    }
}
