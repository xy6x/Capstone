package com.example.amazonclone.controllerLayer;

import com.example.amazonclone.Service.UserService;
import com.example.amazonclone.modelLayer.MerchantStock;
import com.example.amazonclone.modelLayer.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

     @GetMapping("/get")
    public ArrayList<User> getUsers(){

        return userService.getUsers();
    }
    @PostMapping("/post")
    public ResponseEntity addUser(@RequestBody User user , Errors errors){
       if (errors.hasErrors()){
           String message= errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
       }
           userService.addUsers(user);
            return ResponseEntity.status(HttpStatus.OK).body("added user");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateUser(@PathVariable String id,@RequestBody User user , Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean update = userService.updateUser(id,user);
        if (update) {
            return ResponseEntity.status(HttpStatus.OK).body("Update user");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please check  users");
    }@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
         boolean isDelete =userService.deleteUser(id);
        if (isDelete) {
            return ResponseEntity.status(HttpStatus.OK).body("delete user");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please check id user");

    }
    @PutMapping("/buy/{id}/{merchid}/{idProd}")
    public ResponseEntity buying(@PathVariable String id,String merchid, String idProd){

         boolean buy =userService.buying(merchid,idProd);
        if (buy) {
            return ResponseEntity.status(HttpStatus.OK).body("buying");

        }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter ");

    }
}
