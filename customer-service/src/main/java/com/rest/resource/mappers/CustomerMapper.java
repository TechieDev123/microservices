package com.rest.resource.mappers;

import com.rest.resource.bo.AddressBo;
import com.rest.resource.bo.CustomerBo;
import com.rest.resource.entity.Address;
import com.rest.resource.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Address mapAddressEntity(AddressBo addressBo) {
        Address address = new Address();
        address.setAddressType(addressBo.getAddressType());
        address.setStreet1(addressBo.getStreet1());
        address.setStreet2(addressBo.getStreet2());
        address.setCityOrTown(addressBo.getCityOrTown());
        address.setDistrict(addressBo.getDistrict());
        address.setState(addressBo.getState());
        address.setCountry(addressBo.getCountry());
        address.setPinCode(addressBo.getPinCode());
        return address;
    }

    public Customer mapCustomerEntity(CustomerBo customerBo) {
        Customer customer = new Customer();
        customer.setName(customerBo.getName());
        customer.setEmail(customerBo.getEmail());
        customer.setMobileNo(customerBo.getPhone());
        customer.setPassword(customerBo.getPassword());
        customer.setDob(customerBo.getDob());
        customer.setGender(customerBo.getGender());
        return customer;
    }

    public CustomerBo mapCustomerBo(Customer customer) {
        CustomerBo customerBo = new CustomerBo();
        customerBo.setName(customer.getName());
        customerBo.setEmail(customer.getEmail());
        customerBo.setGender(customer.getGender());
        customerBo.setDob(customer.getDob());
        customerBo.setPassword(customer.getPassword());
        customerBo.setPhone(customer.getMobileNo());
        return customerBo;
    }

    public AddressBo mapAddressBo(Address address) {
        AddressBo addressBo = new AddressBo();
        addressBo.setAddressType(address.getAddressType());
        addressBo.setStreet1(address.getStreet1());
        addressBo.setStreet2(address.getStreet2());
        addressBo.setCityOrTown(address.getCityOrTown());
        addressBo.setDistrict(address.getDistrict());
        addressBo.setState(address.getState());
        addressBo.setCountry(address.getCountry());
        addressBo.setPinCode(address.getPinCode());
        return addressBo;
    }

    public Address mapExistingAddressEntity(AddressBo addressBo,Address address){
        address.setAddressType(addressBo.getAddressType());
        address.setStreet1(addressBo.getStreet1());
        address.setStreet2(addressBo.getStreet2());
        address.setCityOrTown(addressBo.getCityOrTown());
        address.setDistrict(addressBo.getDistrict());
        address.setState(addressBo.getState());
        address.setCountry(addressBo.getCountry());
        address.setPinCode(addressBo.getPinCode());
        return address;
    }

}

