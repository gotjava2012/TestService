/**
 * Copyright (c) 2014 Events.com.
 * All Rights Reserved.
 */
package com.events.testservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.events.testservice.entity.ProductEntity;
import com.events.testservice.repository.ProductRepository;


/**
 * Data access object for Product.
 * @author mkent
 *
 */
@Component
public class ProductDao {
    
    @Autowired
    private ProductRepository productRespository;
    
    /**
     * Finds all products and returns a list.
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public List<ProductEntity> findAll() {
    	List<ProductEntity> list = new ArrayList<>();
    	productRespository.findAll().forEach(e -> list.add(e));
  		return list;
    }

    /**
     * Finds a product record by id.
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public ProductEntity findProductById(Long id) {
        return productRespository.findOne(id);
    }

    /**
     * Creates a product record.
     * @param entity
     * @return
     */
    @Transactional
    public ProductEntity createProduct(ProductEntity entity) {
        return productRespository.save(entity);
    }

    /**
     * Deletes a product by id.
     * @param id
     */
	public void delete(Long id) {
		//Calling the delete method from the repository
		productRespository.delete(id);
		
	}

}
