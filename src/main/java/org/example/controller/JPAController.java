package org.example.controller;

import org.example.CustomerService;
import org.example.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jpaex")
class JPAController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(method= RequestMethod.POST, value="/addData")
    public Customer saveCustomer(@RequestBody  Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/listAll")
    public List<Customer> getAllCustomers() { return  customerService.getAllCustomers();};

    /**
     * Usage: http://localhost:8080/jpaex/find/10
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable Long id) {

        try {
            return ResponseEntity.ok(customerService.getCustomerById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * usage: http://localhost:8080/jpaex/findbyid?id=1
     * @param id
     * @return
     */
    @GetMapping("/findbyid")
    public ResponseEntity<Object> getCustomerById(@RequestParam Long id) {

        try {
            return ResponseEntity.ok(customerService.getCustomerById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
