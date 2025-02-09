package com.emart.app.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomerModel {
    private String name;
    private String email;
    private String password;
    private  String phone;
    private  String gender;
    private  String dob;
    private  List<AddressModel> address;
}
