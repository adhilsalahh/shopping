package com.example.shopping.Controller;

import com.example.shopping.Model.Admin;
import com.example.shopping.Model.Category;
import com.example.shopping.Model.Product;
import com.example.shopping.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://127.0.0.1:5502")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public Category createcategoryadd(@RequestBody Category category) {
        return categoryService.createcategory(category);
    };


    @PutMapping("/editcategory")

    public String editcategory (@RequestParam("categoryid") int categoryId,
                                @RequestParam("name") String name  ){
        return categoryService.editcategory(categoryId,name);


    }

    @DeleteMapping("/category/{id}")

    public String deleteid (@PathVariable ("categoryId") int categoryId){
        return categoryService.deletecategoryId (categoryId);
    }
    @GetMapping("/list")
    public List<Category> getALLcategory() {
        return categoryService.getAllProducts();
    }






}
