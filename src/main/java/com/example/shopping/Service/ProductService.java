package com.example.shopping.Service;

import com.example.shopping.Model.Product;
import com.example.shopping.Model.User;
import com.example.shopping.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

//    public Product getProductById(int productId) {
//        return productRepository.findById(productId).get();
//    }
    public Product getProductById(int productId) {

        return productRepository.findById(productId).get();


    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean deleteProduct(int productId) {
        productRepository.deleteById(productId);
        return false;
    }



        public Product updateProduct(Product product) {
            // Check if the product with the given ID exists in the database
            Optional<Product> existingProductOptional = productRepository.findById(product.getProductId());

            if (existingProductOptional.isPresent()) {
                // Product with the given ID exists, update its details
                Product existingProduct = existingProductOptional.get();
                existingProduct.setName(product.getName());

                existingProduct.setPrice(product.getPrice());
                // Set any other fields that you want to update

                // Save the updated product to the database
                return productRepository.save(existingProduct);
            } else {
                // Product with the given ID does not exist
                return null;
            }
        }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }




    public boolean admindeleteProduct(int productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            productRepository.delete(product);
            return true;
        } else {
            return false;
        }
    }
    public List<Product> getAdminProducts() {
        // Implement logic to retrieve products created by admins
        // For example, you can filter products based on some admin-related attribute
        // or perform a join with the user table to get products created by admin users.
        return null;
    }

    public List<Product> admingetAllProducts() {
        return productRepository.findAll();
    }


    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
    public List<Product> userAllProducts() {
        return productRepository.findAll();
    }


}





