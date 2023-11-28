package com.example.amazonclone.modelLayer;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotEmpty(message = "please enter id")
    private String id;
    @NotEmpty(message = "please enter user Name")
    @Size(min = 5,message = "The name's minimum letter is 5")
    private String userName;
    @NotEmpty(message = "please enter password")
    @Size(min = 6,message = "The password's minimum letter is 5")
    private String password;
    @NotEmpty(message = "please enter emil")
    @Email(message = "please enter Correct email")
    private String email;
    @NotEmpty(message = "please enter role")
   @Pattern(regexp = "(Admin|Customer)" ,message = "empty, have to be in ( “Admin”,”Customer”))")
    private String role;
    @Positive
    @NotNull
    private double balance;


}
