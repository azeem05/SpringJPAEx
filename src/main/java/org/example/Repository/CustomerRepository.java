package org.example.Repository;

import java.util.List;
import org.example.Entity.Customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);

    @Query("Select a from Customer a where a.firstName=:fname")
    List<Customer> findByFirstName(@Param("fname") String fname);
}