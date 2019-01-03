/**
 * 
 */
package com.example.crudrepository.service.category;

import com.example.crudrepository.exception.ConstraintsViolationException;
import com.example.crudrepository.exception.EntityNotFoundException;
import com.example.crudrepository.model.Category;

/**
 * @author Arnaud
 *
 */

public interface CategoryService {

	Category find(String categorytId) throws EntityNotFoundException;
	Category create(Category category) throws ConstraintsViolationException;
}
