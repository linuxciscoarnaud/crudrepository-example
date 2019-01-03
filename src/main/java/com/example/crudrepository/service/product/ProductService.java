/**
 * 
 */
package com.example.crudrepository.service.product;

import com.example.crudrepository.exception.ConstraintsViolationException;
import com.example.crudrepository.exception.EntityNotFoundException;
import com.example.crudrepository.model.Product;

/**
 * @author Arnaud
 *
 */

public interface ProductService {

	Product find(String productId) throws EntityNotFoundException;
	Product create(Product product) throws ConstraintsViolationException, EntityNotFoundException;
	void delete(String productId) throws EntityNotFoundException;
	void updateUnitsInStock(String productId, Long unitsInStock) throws EntityNotFoundException;
}
