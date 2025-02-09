package com.rest.resource.bo;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomerBo {
    private String name;
    private String email;
    private String password;
    private  String phone;
    private  String gender;
    private  String dob;
    private  List<AddressBo> address;
}
