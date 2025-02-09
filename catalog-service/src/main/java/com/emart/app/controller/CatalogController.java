package com.emart.app.controller;

import com.emart.app.bo.CatalogBo;
import com.emart.app.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        System.out.println("CatalogController");
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createCatalog(@RequestBody CatalogBo catalogBo) {
        return catalogService.createCatalog(catalogBo);
    }

    @RequestMapping(method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<CatalogBo> getAllCatalogs() {
        return catalogService.getAllCatalog();
    }
}
