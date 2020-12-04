package com.farmer.database.farmerdb.Controllers;

import com.farmer.database.farmerdb.Entities.Customer;
import com.farmer.database.farmerdb.Entities.Product;
import com.farmer.database.farmerdb.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){ return productService.saveProducts(products); }

    @GetMapping("/Products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/ProductByName/{name}")
    public List<Product> getProductByName(@PathVariable String name){ return productService.getProductByName(name); }

    @GetMapping("/ProductByCategory/{Category}")
    public List<Product> getProductByCategory(@PathVariable  String Category){ return productService.getProductByCategory(Category); }

    @GetMapping("/ProductByID/{id}")
    public Product getProductByID(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @PutMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/getProductList")
    public List<String> getProductOptions(){return productService.getProductOptions();}

}
