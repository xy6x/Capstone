package com.example.amazonclone.modelLayer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
    @NotEmpty(message = "please enter id")
    private String id;
    @Size(min = 3,message = "min the name 3 char")
    @NotEmpty(message = "please enter name")
    private String name;
}
