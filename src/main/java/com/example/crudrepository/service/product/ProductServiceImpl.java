/**
 * 
 */
package com.example.crudrepository.service.product;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.crudrepository.exception.ConstraintsViolationException;
import com.example.crudrepository.exception.EntityNotFoundException;
import com.example.crudrepository.model.Category;
import com.example.crudrepository.model.Product;
import com.example.crudrepository.repository.CategoryRepository;
import com.example.crudrepository.repository.ProductRepository;
import com.example.crudrepository.service.category.CategoryServiceImpl;

/**
 * @author Arnaud
 *
 */

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductServiceImpl(final ProductRepository productRepository, 
			                  final CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	private Product findProductChecked(String productId) throws EntityNotFoundException {
		return productRepository.findById(productId)
				.orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + productId));
	}
	
	/* (non-Javadoc)
	 * @see com.example.crudrepository.service.product.ProductService#find(java.lang.String)
	 */
	
	/**
     * Selects a product by id.
     *
     * @param productId
     * @return found product
	 * @throws EntityNotFoundException 
     */
	@Override
	public Product find(String productId) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return findProductChecked(productId);
	}

	/**
     * Creates a new product.
     *
     * @param product
     * @return
     * @throws ConstraintsViolationException if any constraint is violated, ... .
	 * @throws EntityNotFoundException 
     */
	@Override
	public Product create(Product product) throws ConstraintsViolationException, EntityNotFoundException {
		// TODO Auto-generated method stub
		Product newProduct;
		
		Category productCategory = categoryRepository.findCategoryByName(product.getCategory().getName());
		if (productCategory != null) {
			product.setCategory(productCategory);
			try {
				newProduct = productRepository.save(product);
			} catch (DataIntegrityViolationException e) {
				LOG.warn("ConstraintsViolationException while creating a product: {}", product, e);
	            throw new ConstraintsViolationException(e.getMessage());
			}
		} else {
			Category newCategory = new Category();
			newCategory.setName(product.getCategory().getName());
			Category savedCategory = categoryRepository.save(newCategory);
			
			product.setCategory(savedCategory);
			try {
				newProduct = productRepository.save(product);
			} catch (DataIntegrityViolationException e) {
				LOG.warn("ConstraintsViolationException while creating a product: {}", product, e);
	            throw new ConstraintsViolationException(e.getMessage());
			}
		}
		
		return newProduct;
	}

	/**
     * Deletes an existing product by id.
     *
     * @param productId
     * @throws EntityNotFoundException if no product with the given id was found.
     */
	@Override
	@Transactional
	public void delete(String productId) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		Product product = findProductChecked(productId);
		productRepository.delete(product);
	}

	@Override
	@Transactional
	public void updateUnitsInStock(String productId, Long unitsInStock) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		Product productWithNewInfos = findProductChecked(productId);
		
		productWithNewInfos.setUnitsInStock(unitsInStock);
	}
}
