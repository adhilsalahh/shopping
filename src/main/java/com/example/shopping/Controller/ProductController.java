package com.example.shopping.Controller;

import com.example.shopping.Model.Product;
import com.example.shopping.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5502")

@RestController
@RequestMapping("/api/products")
//@CrossOrigin(origins = "http://127.0.0.1:5502")
public class ProductController {
@Autowired
    ProductService productService;
    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addadmin() {
        // Add user logic
        return "product added successfullyz";
    }

    @GetMapping("/list")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/GET/{id}")
    public Product getProductById(@PathVariable ("productId")  int productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/addproduct")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }


//    @PutMapping("/update/{id}")
//    public Product updateProduct(@PathVariable int productId , @RequestBody Product product) {
//        product.setProductId(productId); // Ensure the ID is set
//
//        return productService.createProduct(product);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

}
