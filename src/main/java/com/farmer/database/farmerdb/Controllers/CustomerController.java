package com.farmer.database.farmerdb.Controllers;

import com.farmer.database.farmerdb.Entities.Customer;
import com.farmer.database.farmerdb.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/addCustomers")
    public List<Customer> addCustomer(@RequestBody List<Customer> customer){
        return customerService.saveCustomers(customer);
    }

    @GetMapping("/Customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/CustomerByName/{name}")
    public List<Customer> getCustomerByName(@PathVariable String name){
        return customerService.getCustomerByName(name);
    }

    @GetMapping("/CustomerByID/{id}")
    public Customer getCustomerByID(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/CustomerByEmail/{Email}")
    public Customer getCustomerByEmail(@PathVariable String Email){
        return customerService.getCustomerByEmail(Email);
    }

    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @PutMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }
}