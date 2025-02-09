package com.emart.app.service;

import com.emart.app.bo.CatalogBo;
import com.emart.app.entity.CatalogEntity;
import com.emart.app.respository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;

    public String createCatalog(CatalogBo catalogBo) {
        CatalogEntity catalog = new CatalogEntity();
        catalog.setUid(catalogBo.getUid());
        catalog.setName(catalogBo.getName());
        catalog.setDescription(catalogBo.getDescription());
        catalog.setTags(catalogBo.getTags());
        catalogRepository.save(catalog);
        return "Catalog created successfully";
    }

    public List<CatalogBo> getAllCatalog() {
        List<CatalogEntity> catalogEntities = catalogRepository.findAll();
        if (!CollectionUtils.isEmpty(catalogEntities)) {
            return catalogEntities.stream().map(catalogEntity -> {
                CatalogBo catalogBo = new CatalogBo();
                catalogBo.setName(catalogEntity.getName());
                catalogBo.setDescription(catalogEntity.getDescription());
                catalogBo.setTags(catalogEntity.getTags());
                return catalogBo;
            }).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }
}
