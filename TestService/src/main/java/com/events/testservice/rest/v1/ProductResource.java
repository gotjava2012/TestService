/**
 * Copyright (c) 2014 Events.com.
 * All Rights Reserved.
 */
package com.events.testservice.rest.v1;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.events.testservice.dao.ProductDao;
import com.events.testservice.entity.ProductEntity;
import com.events.testservice.repository.ProductRepository;
import com.events.testservice.rest.v1.dto.ProductDto;

/**
 * Resource endpoint to handle product object requests.
 * @author mkent
 *
 */
@Path("/v1/products")
public interface ProductResource {
	
	/**
     * Gets all products
     * @return The id of the new record
     */
	@GET
    @Path("/")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<ProductEntity> getProducts();

	/**
     * Gets a product by it's key.
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getProduct(@PathParam("id") Long id);
       
    /**
     * Creates a product record based on the data passed in.  Returns the id of the record.
     * @param sampleDto
     * @return The id of the new record
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(ProductDto sampleDto);
    
    /**
     * Updates a product record based on the incoming object.
     * @param id
     * @return The id of the new record
     */
    @PUT
	@Produces(value=MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Response updateProduct(ProductDto sampleDto);
    
    /**
     * Deletes a product record based on the data passed in.  
     * @param id
     * @return The id of the new record
     */
    @DELETE
   	@Produces(value=MediaType.APPLICATION_JSON)
   	@Path("/{id}")
   	public Response deleteProduct(@PathParam("id") Long id);
}
