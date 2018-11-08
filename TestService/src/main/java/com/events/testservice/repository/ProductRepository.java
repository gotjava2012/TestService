/**
 * Copyright (c) 2014 Events.com.
 * All Rights Reserved.
 */
package com.events.testservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.events.testservice.entity.ProductEntity;
import com.events.testservice.rest.v1.dto.ProductDto;

/**
 * Spring data sample CRUD repository.
 * @author mkent
 *
 */
@Repository
public interface ProductRepository  extends CrudRepository<ProductEntity, Long> {

}
