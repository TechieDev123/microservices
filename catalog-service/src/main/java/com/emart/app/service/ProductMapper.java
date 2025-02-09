package com.emart.app.service;

import com.emart.app.bo.ProductBo;
import com.emart.app.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductBo productDtoMapper(ProductEntity productEntity) {
        ProductBo productDto = new ProductBo();
        productDto.setUid(productEntity.getUid());
        productDto.setName(productEntity.getName());
        productDto.setUnitPrice(productEntity.getUnitPrice());
        productDto.setDescription(productEntity.getDescription());
        productDto.setDiscountedPrice(productEntity.getDiscountedPrice());
        productDto.setCategory(productEntity.getCategory());
        productDto.setImageUrl(productEntity.getImageUrl());
        productDto.setAvailableQuantity(productEntity.getAvailableQuantity());
        productDto.setSku(productEntity.getSku());
        productDto.setTags(productEntity.getTags());
        productDto.setRatings(productEntity.getRatings());
        productDto.setReviews(productEntity.getReviews());
        productDto.setNoOfRatings(productEntity.getNoOfRatings());
        return productDto;}
}
