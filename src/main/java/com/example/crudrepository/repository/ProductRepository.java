/**
 * 
 */
package com.example.crudrepository.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.crudrepository.model.Product;

/**
 * @author Arnaud
 *
 */
public interface ProductRepository extends CrudRepository<Product, String> {

}
