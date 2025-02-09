package com.rest.resource.controller;

import com.rest.resource.bo.CustomerBo;
import com.rest.resource.service.CustomerService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createCustomer(@RequestBody CustomerBo customerBo) {
        return customerService.customerAccountCreation(customerBo);
    }

    //@PreAuthorize("hasAnyRole('USER')")
    //@Secured("ROLE_USER")
    @RequestMapping(path = "/{mobile-no}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerBo getCustomerByMobileNo(@PathVariable("mobile-no") String mobileNo) {
        return customerService.getCustomer(mobileNo);
    }

    @RequestMapping(path = "/{mobile-no}", method = RequestMethod.DELETE)
    public String deleteCustomerByMobileNo(@PathVariable("mobile-no") String mobileNo) {
        return customerService.deleteCustomer(mobileNo);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateCustomer(@RequestBody CustomerBo customerBo) {
        return customerService.updateCustomerInfo(customerBo);
    }

    @RequestMapping(path = "/new-address", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateNewAddress(@RequestBody CustomerBo customerBo) {
        return customerService.updateNewAddress(customerBo);
    }

    @RequestMapping(path = "/existing-address", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateExistingAddress(@RequestBody CustomerBo customerBo) {
        return customerService.updateExistingAddress(customerBo);
    }
}

