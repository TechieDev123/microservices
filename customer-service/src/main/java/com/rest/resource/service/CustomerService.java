package com.rest.resource.service;

import com.rest.resource.bo.AddressBo;
import com.rest.resource.bo.CustomerBo;
import com.rest.resource.entity.Address;
import com.rest.resource.entity.Customer;
import com.rest.resource.mappers.CustomerMapper;
import com.rest.resource.repository.AddressRepository;
import com.rest.resource.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Transactional
    public String customerAccountCreation(CustomerBo customerBo) {
        Customer customer = customerMapper.mapCustomerEntity(customerBo);
        customerRepository.save(customer);

        List<AddressBo> addressBoList = customerBo.getAddress();
        for (AddressBo addressBo : addressBoList) {
            Address address = customerMapper.mapAddressEntity(addressBo);
            address.setCustomer(customer);
            addressRepository.save(address);
        }
        return "Customer Account Created";
    }

    @Transactional(readOnly = true)
    public CustomerBo getCustomer(String mobileNo) {
        Customer customer = customerRepository.findByPhoneNo(mobileNo);
        CustomerBo customerBo = customerMapper.mapCustomerBo(customer);
        List<AddressBo> addressBoList = new ArrayList<>();
        List<Address> addressList = customer.getAddresses();
        for (Address address : addressList) {
            AddressBo addressBo = customerMapper.mapAddressBo(address);
            addressBoList.add(addressBo);
        }
        customerBo.setAddress(addressBoList);
        return customerBo;
    }

    @Transactional
    public String deleteCustomer(String mobileNo) {
        Customer customer = customerRepository.findByPhoneNo(mobileNo);
        customerRepository.deleteById(customer.getId());
        return "Customer Deleted Successfully";
    }

    @Transactional
    public String updateCustomerInfo(CustomerBo customerBo) {
        Customer customer = customerRepository.findByPhoneNo(customerBo.getPhone());
        customer.setName(customerBo.getName());
        customer.setEmail(customerBo.getEmail());
        customer.setPassword(customerBo.getPassword());
        customer.setDob(customerBo.getDob());
        customer.setGender(customerBo.getGender());
        return "Customer Updated Successfully";
    }

    @Transactional
    public String updateNewAddress(CustomerBo customerBo) {
        Customer customer = customerRepository.findByPhoneNo(customerBo.getPhone());
        if (customer == null) {
            throw new RuntimeException("Customer Not Found");
        } else {
            List<AddressBo> addressBoList = customerBo.getAddress();
            List<Address> addressList = customer.getAddresses();
            for (AddressBo addressBo : addressBoList) {
                Address address = customerMapper.mapAddressEntity(addressBo);
                address.setCustomer(customer);
                addressList.add(address);
            }
        }
        return "Customer Updated Successfully";
    }

    @Transactional
    public String updateExistingAddress(CustomerBo customerBo) {
        Customer customer = customerRepository.findByPhoneNo(customerBo.getPhone());
        if (customer == null) {
            throw new RuntimeException("Customer Not Found");
        } else {
            List<Address> addressList = customer.getAddresses();
            List<AddressBo> addressBoList = customerBo.getAddress();
            for (AddressBo addressBo : addressBoList) {
                Optional<Address> addressOptional = addressList.stream().filter(address -> Objects.equals(address.getAddressType(), addressBo.getAddressType())).findFirst();
                if (addressOptional.isPresent()) {
                    Address address = addressOptional.get();
                    customerMapper.mapExistingAddressEntity(addressBo, address);
                }
            }
        }
        return "Customer Updated Successfully";
    }
}