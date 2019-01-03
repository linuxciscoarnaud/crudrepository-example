/**
 * 
 */
package com.example.crudrepository.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.crudrepository.model.Category;

/**
 * @author Arnaud
 *
 */

public interface CategoryRepository extends CrudRepository<Category, String>  {

	Category findCategoryByName(String name);
}
