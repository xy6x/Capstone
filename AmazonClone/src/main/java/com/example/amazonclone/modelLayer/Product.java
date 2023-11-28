package com.example.amazonclone.modelLayer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    @NotEmpty(message = "please enter id")
    private String id;
    @NotEmpty(message = "please enter name")
    @Size(min = 3,message = "Minimum letters of the name 3 ")
    private String name;
    @NotNull(message = "please enter price")
    @Positive(message = "please enter number positive")
    private double price;
    @NotEmpty(message = "please enter categoryID")
    private String categoryID;
}
