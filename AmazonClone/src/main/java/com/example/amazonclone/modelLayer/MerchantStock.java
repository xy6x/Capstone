package com.example.amazonclone.modelLayer;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotEmpty(message = "please enter id")
    private String id ;
    @NotEmpty(message = "please enter productID")
    private String productID;
    @NotEmpty(message = "please enter merchantID")
    private String merchantID;
    @NotNull
    @Min(value = 10,message =  "please enter stock and the min is 10 ")
    private int stock;

}
