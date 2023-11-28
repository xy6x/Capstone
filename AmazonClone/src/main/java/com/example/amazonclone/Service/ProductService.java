package com.example.amazonclone.Service;

import com.example.amazonclone.modelLayer.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor

public class ProductService{
    private final CategoryService categoryService;

    ArrayList<Product> products =new ArrayList<>();
    public ArrayList<Product> getProducts(){
        return products;
    }
    public boolean addProducts(Product product){

        for (int j = 0; j <categoryService.categories.size() ; j++) {
            if (categoryService.categories.get(j).getId().equals(product.getCategoryID())) {
                products.add(product);
                return true;
        }

        }
           return false ;
    }
    public boolean updateProducts(String id ,Product product){
        for (int i = 0; i <categoryService.categories.size() ; i++) {
            if (categoryService.categories.get(i).getId().equals(product.getCategoryID().equals(id))) {
                products.set(i,product);
                return true;
            }
        }
        return false;
    }
    public boolean deleteProducts(String id){
        for (Product p:products
             ) {
            if (p.getId().equals(id)) {
                products.remove(id);
                return true;
            }
        }
        return false;
    }
}
