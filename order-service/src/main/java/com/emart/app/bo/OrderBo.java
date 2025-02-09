package com.emart.app.bo;

import lombok.Data;

import java.util.List;

@Data
public class OrderBo {
    private String phoneNumber;
    private List<ProductBo> productBos;
}
