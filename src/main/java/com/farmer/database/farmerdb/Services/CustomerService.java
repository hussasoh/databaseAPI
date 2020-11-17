package com.farmer.database.farmerdb.Services;

import com.farmer.database.farmerdb.Entities.Customer;
import com.farmer.database.farmerdb.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //Save one Customer
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    //Save a list of Customers
    public List<Customer> saveCustomers(List<Customer> customers){
        return customerRepository.saveAll(customers);
    }

    //retrieve all Customers
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public  Customer getCustomerById(int id){
        return customerRepository.findById(id).orElse(null);
    }
    public List<Customer> getCustomerByName(String name){ return customerRepository.findByName(name); }
    public Customer getCustomerByEmail(String email){
        return customerRepository.findByEmail(email);
    }

    //Delete
    public String deleteCustomer(int id){
        customerRepository.deleteById(id);
        return "Customer Removed! " + id;
    }

    //Update
    public Customer updateCustomer(Customer customer){
        Customer existingCustomer = customerRepository.findById(customer.CustomerID).orElse(null);
        existingCustomer.CustomerName = customer.CustomerName;
        existingCustomer.CustomerEmail = customer.CustomerEmail;
        existingCustomer.CustomerPassword= customer.CustomerPassword;
        return customerRepository.save(existingCustomer);
    }

}
