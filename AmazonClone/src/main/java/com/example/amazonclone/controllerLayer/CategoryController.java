package com.example.amazonclone.controllerLayer;

import com.example.amazonclone.Service.CategoryService;
import com.example.amazonclone.modelLayer.Category;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping("/get")

    public ArrayList<Category> getCategory(){

        return    categoryService.get();
    }@PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category , Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        categoryService.addCategories(category);
        return ResponseEntity.status(HttpStatus.OK).body("added Category");
    }@PutMapping("/put/{id}")
    public ResponseEntity updateCategory(@PathVariable String id,@RequestBody @Valid Category category , Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        categoryService.updateCategories(id, category);
        return ResponseEntity.status(HttpStatus.OK).body("Update Category");

    }@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id){
        boolean isDelete =categoryService.deleteCategories(id);
        if (isDelete) {
            return ResponseEntity.status(HttpStatus.OK).body("Category deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter id true");

    }
}
