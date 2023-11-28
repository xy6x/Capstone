package com.example.amazonclone.Service;

import com.example.amazonclone.modelLayer.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    ArrayList<Category> categories =new ArrayList<>();
    public ArrayList<Category> get(){
        return categories;
    }
    public void addCategories(Category category){
        categories.add(category);
    }
    public boolean updateCategories(String id, Category category){
        for (int i = 0; i <categories.size() ; i++) {
            if (categories.get(i).getId().equals(id)) {
                categories.set(i,category);
                return true;
            }
        }
        return false;
    }
    public boolean deleteCategories(String id){
        for (Category c:categories
             ) {
            if (c.getId().equals(id)) {
                categories.remove(id);
                return true;
            }
        }
        return false;
    }

}
