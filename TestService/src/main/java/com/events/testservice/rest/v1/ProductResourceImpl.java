/**
 * Copyright (c) 2014 Events.com.
 * All Rights Reserved.
 */
package com.events.testservice.rest.v1;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.events.testservice.dao.ProductDao;
import com.events.testservice.entity.ProductEntity;
import com.events.testservice.entity.ProductEntity.Builder;
import com.events.testservice.rest.v1.dto.ProductDto;

/**
 * Product resource implementation.
 * @author mkent
 *
 */
@Service
public class ProductResourceImpl implements ProductResource {
    
    @Autowired
    private ProductDao productDao;

    @Override
    public Response getProduct(Long id) {
        if (id == null) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).build();
        }
        ProductEntity entity = productDao.findProductById(id);
        if (entity == null) {
            return Response.status(HttpStatus.NO_CONTENT.value()).build();
        }
        ProductDto dto = new ProductDto.Builder()
            .id(entity.getId())
            .name(entity.getName())
            .build();
        return Response.status(HttpStatus.OK.value()).entity(dto).build();
    }

    @Override
    public Response createProduct(ProductDto sampleDto) {
        if (sampleDto == null) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).build();
        }
        ProductEntity entity = new ProductEntity.Builder()
            .id(sampleDto.getId())
            .name(sampleDto.getName())
            .build();
        entity = productDao.createProduct(entity);
        ProductDto dto = new ProductDto.Builder()
            .id(entity.getId())
            .name(entity.getName())
            .build();
        return Response.status(HttpStatus.OK.value()).entity(dto).build();
    }
    
    @Override
	public List<ProductEntity> getProducts() {
    	//Returns a list of all products
  		return productDao.findAll();
    
}

	@Override
	public Response updateProduct(ProductDto sampleDto) {
		//Validate the incoming data is not null
		if (sampleDto == null) {
            return Response.status(HttpStatus.BAD_REQUEST.value()).build();
        }
		//Look up existing product
		 ProductEntity entity = productDao.findProductById(sampleDto.getId());
		 //Check if value is actually exists if not return with No Content message
		 if (entity == null) {
	            return Response.status(HttpStatus.NO_CONTENT.value()).build();
	        }
		 
		 //Creating a new builder to assign changed values to
		 Builder newEntity = new ProductEntity.Builder();
		 //Check to see if the name has changed; if so set the new name
		 if(!entity.getName().equals(sampleDto.getName())) {
			 newEntity.name(sampleDto.getName());
		 }
		 //Create the new Product that will be replacing the old product...rather merged with the existing
        entity = productDao.createProduct(newEntity.build());
        ProductDto dto = new ProductDto.Builder()
            .id(entity.getId())
            .name(entity.getName())
            .build();
        return Response.status(HttpStatus.OK.value()).entity(dto).build();
	}

	@Override
	public Response deleteProduct(Long id) {
		//Calling delete method from the dao base on product id
		productDao.delete(id);
		return Response.status(HttpStatus.OK.value()).build();
	}
}