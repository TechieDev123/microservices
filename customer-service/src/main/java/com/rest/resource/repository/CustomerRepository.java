package com.rest.resource.repository;

import com.rest.resource.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query(value = "from Customer where mobileNo=:phoneNo")
    Customer findByPhoneNo(String phoneNo);
}
