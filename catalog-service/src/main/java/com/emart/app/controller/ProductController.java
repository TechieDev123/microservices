package com.emart.app.controller;

import com.emart.app.bo.ProductBo;
import com.emart.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/{catalog-name}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addProduct(@RequestBody List<ProductBo> productBos, @PathVariable("catalog-name") String catalogName){
        return productService.addProducts(productBos, catalogName);
    }

    @RequestMapping(path = "/{sku}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductBo getProductBySku(@PathVariable("sku") String sku) {
        return productService.getProduct(sku);
    }

    @GetMapping(path = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductBo> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(path = "/all/{catalog-name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductBo> getAllProductsByCatalog(@PathVariable("catalog-name") String catalogName){
        return productService.getAllByCatalog(catalogName);
    }

    @DeleteMapping
    public String deleteAllProducts(){
        productService.deleteProducts();
        return "Success";
    }
}
