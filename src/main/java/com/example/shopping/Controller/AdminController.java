package com.example.shopping.Controller;

import com.example.shopping.Dto.AdminLoginRequst;
import com.example.shopping.Dto.LogingRequst;
import com.example.shopping.Model.Admin;
import com.example.shopping.Model.Product;
import com.example.shopping.Model.User;
import com.example.shopping.Service.AdminSerice;
import com.example.shopping.Service.ProductService;
import com.example.shopping.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://127.0.0.1:5502")
public class AdminController {

    @Autowired
    AdminSerice adminSerice;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @GetMapping("/count")
    public long getUserCount() {
        return userService.getUserCount();
    }


    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String addadmin() {
        // Add user logic
        return "admin added successfullyz";
    }
    @PostMapping("/add")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminSerice.createAdmin(admin);
    };
    @PutMapping("/editPassword") // id use cheythitt password edit cheyann vendeee
    public String editpassword(@RequestParam ("adminId") int adminId ,
                               @RequestParam ("password") String password ){
        return adminSerice.editpassword(adminId,password);
    }
    @DeleteMapping("/delete/{id}")
    public  String deleteid (@PathVariable ("adminId") int adminId){
        return adminSerice.deleteid(adminId);
    }
    @PutMapping("/editName")
    public String editname(@RequestParam ("adminId") int adminId  ,
                           @RequestParam ("name") String name  ){
        return adminSerice.editname(adminId,name);
    }

    @PostMapping("/adminloging")
    public ResponseEntity<Admin> login(@RequestBody AdminLoginRequst adminLoginRequest) {
        Admin admin = adminSerice.getgmailpassword(adminLoginRequest.getGmail(), adminLoginRequest.getPassword());
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/adminadd/product")     //admin product add cheyannn
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    @PutMapping("/products/{productId}")       //product edit update cheyann
    public ResponseEntity<String> updateProduct(@PathVariable int productId, @RequestBody Product product) {
        product.setProductId(productId);
        Product updatedProduct = productService.updateProduct(product);
        if (updatedProduct != null) {
            return ResponseEntity.ok("Product updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/products/delete/{productId}")    //produt delete cheyann
    public ResponseEntity<String> deleteadminProduct(@PathVariable int productId) {
        boolean deleted = productService.admindeleteProduct(productId);
        if (deleted) {
            return ResponseEntity.ok("Product deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listaproducts")
    public List<Product> admingetProducts() {
        return productService.admingetAllProducts() ;
    }

    @DeleteMapping("/deleteproducts")     //FULL  PRODUCT DELETE CHEYYANNNN
    public ResponseEntity<String> deleteAllProducts() {
        productService.deleteAllProducts();
        return new ResponseEntity<>("All products deleted successfully", HttpStatus.OK);
    }

}






