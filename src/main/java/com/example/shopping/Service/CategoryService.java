package com.example.shopping.Service;

import com.example.shopping.Model.Admin;
import com.example.shopping.Model.Category;
import com.example.shopping.Model.Product;
import com.example.shopping.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public Category createcategory(Category category) {
        return categoryRepository.save(category);
    }
    public String editcategory(int categoryId, String name){
        Category category= categoryRepository.findById(categoryId).get();
        category.setName(name);
        categoryRepository.save(category);
        return "Successfull";
    }

    public String deletecategoryId (int categoryId ){
        Category category = categoryRepository.findById(categoryId).get();
        categoryRepository.deleteById(categoryId);
        return "Successfull";
    }

    public List<Category> getAllProducts() {
        return categoryRepository.findAll();

    }
}
