package com.example.amazonclone.controllerLayer;

import com.example.amazonclone.Service.CategoryService;
import com.example.amazonclone.Service.ProductService;
import com.example.amazonclone.modelLayer.Category;
import com.example.amazonclone.modelLayer.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private  final ProductService productService;
    private final CategoryService categoryService;
    @GetMapping("/get")
     public ResponseEntity getProduct(){
         return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
     }
     @PostMapping("/add")
     public  ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
         if (errors.hasErrors()) {
             String message =errors.getFieldError().getDefaultMessage();
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
         }

           boolean be =productService.addProducts(product);
         if (be) {
             return ResponseEntity.status(HttpStatus.OK).body("added product");

         }
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter number true");

     }
     @PutMapping("/put/{id}")
     public ResponseEntity updateProduct(@PathVariable String id ,@RequestBody @Valid Product product, Errors errors ){
         if (errors.hasErrors()) {
             String message =errors.getFieldError().getDefaultMessage();
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
         }
         boolean b2 = productService.updateProducts(id,product);
         if (b2) {


             return ResponseEntity.status(HttpStatus.OK).body("update product");
         }
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter number true");
     }
     @DeleteMapping("/delete/{id}")
     public ResponseEntity deleteProduct(@PathVariable String id){
         boolean isDelete =productService.deleteProducts(id);
         if (isDelete) {
             return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
         }
         productService.deleteProducts(id);
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter id true");

     }
     }

