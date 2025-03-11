package org.example;

import org.example.Entity.Customer;
import org.example.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        System.out.println("Customer details: customer firstname="+customer.getFirstName());
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        Iterator<Customer> iter= customerRepository.findAll().iterator();
        List<Customer> customers=new ArrayList<>();
        while(iter.hasNext()) {
            customers.add(iter.next());
        }
        return customers;
    }

    public Customer getCustomerById(Long id) throws Exception {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(!customerOptional.isEmpty()) {
            return customerOptional.get();
        }
        else throw new Exception("No customer details found");
    }
}
