/**
 * 
 */
package com.example.crudrepository.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudrepository.exception.ConstraintsViolationException;
import com.example.crudrepository.exception.EntityNotFoundException;
import com.example.crudrepository.model.Product;
import com.example.crudrepository.service.product.ProductService;

/**
 * @author Arnaud
 *
 */

@RestController
@RequestMapping("products")
public class ProductRestController {

	private final ProductService productService;
	
	@Autowired
	public ProductRestController(final ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/product/{productId}")
	public Product getProductByProductId(@PathVariable String productId) throws EntityNotFoundException {
		return productService.find(productId);
	}
	
	@PostMapping("/product/add")
    @ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@Valid @RequestBody Product product) throws ConstraintsViolationException, EntityNotFoundException {
		return productService.create(product);
	}
	
	@DeleteMapping("/product/{productId}")
	public void deleteProduct(@PathVariable String productId) throws EntityNotFoundException {
		productService.delete(productId);
	}
	
	@PutMapping("/product/{productId}/{unitsInStock}")
	public void updateUnitsInStock(
	        @PathVariable String productId, @PathVariable Long unitsInStock)
	        throws EntityNotFoundException {
		
		productService.updateUnitsInStock(productId, unitsInStock);
	}
}
