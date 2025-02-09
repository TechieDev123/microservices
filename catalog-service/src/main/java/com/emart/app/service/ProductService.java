package com.emart.app.service;

import com.emart.app.bo.CatalogBo;
import com.emart.app.bo.ProductBo;
import com.emart.app.entity.CatalogEntity;
import com.emart.app.entity.ProductEntity;
import com.emart.app.respository.CatalogRepository;
import com.emart.app.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private ProductMapper productDtoMapper;


    public String addProducts(List<ProductBo> productBoList, String catalogName) {
        CatalogEntity catalogEntity = catalogRepository.findByName(catalogName);
        if (catalogEntity == null) {
            return "Catalog does not exist";
        } else {
            List<ProductEntity> productEntities = new ArrayList<>();
            for (ProductBo productBo : productBoList) {
                ProductEntity productEntity = new ProductEntity();
                productEntity.setUid(productBo.getUid());
                productEntity.setCatalogName(catalogName);
                productEntity.setDescription(productBo.getDescription());
                productEntity.setName(productBo.getName());
                productEntity.setAvailableQuantity(productBo.getAvailableQuantity());
                productEntity.setUnitPrice(productBo.getUnitPrice());
                productEntity.setDiscountedPrice(productBo.getDiscountedPrice());
                productEntity.setSku(productBo.getSku());
                productEntity.setImageUrl(productBo.getImageUrl());
                productEntity.setCategory(productBo.getCategory());
                productEntity.setTags(productBo.getTags());
                productEntity.setRatings(productBo.getRatings());
                productEntity.setReviews(productBo.getReviews());
                productEntity.setNoOfRatings(productBo.getNoOfRatings());
                productEntities.add(productEntity);
            }
            productRepository.saveAll(productEntities);
            return "Product added successfully into catalog :: " + catalogName;
        }
    }

    public ProductBo getProduct(String sku) {
        Optional<ProductEntity> optional = productRepository.findById(sku);
        if (optional.isPresent()) {
            ProductEntity productEntity = optional.get();
            return productDtoMapper.productDtoMapper(productEntity);
        } else {
            throw new RuntimeException("Product is not available with the " + sku);
        }
    }


    public List<ProductBo> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        if (!CollectionUtils.isEmpty(productEntities)) {
            return productEntities.stream().map(productEntity -> productDtoMapper.productDtoMapper(productEntity)).collect(Collectors.toList());
        } else {
            throw new RuntimeException("Products is not available");
        }
    }

    public List<ProductBo> getAllByCatalog(String catalogName) {
        List<ProductEntity> productEntities = productRepository.findByCatalogName(catalogName);
        if (!CollectionUtils.isEmpty(productEntities)) {
            return productEntities.stream().map(productEntity -> productDtoMapper.productDtoMapper(productEntity)).collect(Collectors.toList());
        } else {
            throw new RuntimeException("Products is not available");
        }
    }

    public void deleteProducts(){
        productRepository.deleteAll();
    }
}
