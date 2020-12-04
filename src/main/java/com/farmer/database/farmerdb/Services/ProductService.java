package com.farmer.database.farmerdb.Services;


import com.farmer.database.farmerdb.Entities.Customer;
import com.farmer.database.farmerdb.Entities.Product;
import com.farmer.database.farmerdb.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //Save one Product
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    //Save a list of Products
    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    //retrieve all Products
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public  Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }
    public List<Product> getProductByName(String name){
        return productRepository.findByName(name);
    }
    public List<Product> getProductByCategory(String Category){
        return productRepository.findByCategory(Category);
    }

    //Delete
    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Product Removed! " + id;
    }

    //Update
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.ProductID).orElse(null);
        existingProduct.ProductName = product.ProductName;
        existingProduct.ProductCategory = product.ProductCategory;
        return productRepository.save(existingProduct);
    }

    //options function
    public List<String> getProductOptions(){
        return productRepository.getProductOptions();
    }
}
