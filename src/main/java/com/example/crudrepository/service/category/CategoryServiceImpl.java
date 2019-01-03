/**
 * 
 */
package com.example.crudrepository.service.category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.crudrepository.exception.ConstraintsViolationException;
import com.example.crudrepository.exception.EntityNotFoundException;
import com.example.crudrepository.model.Category;
import com.example.crudrepository.repository.CategoryRepository;

/**
 * @author Arnaud
 *
 */

@Service
public class CategoryServiceImpl implements CategoryService {

	private static final Logger LOG = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	private final CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(final CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public Category findCategoryChecked(String categoryId) throws EntityNotFoundException {
		return categoryRepository.findById(categoryId)
				.orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + categoryId));
	}
	
	/* (non-Javadoc)
	 * @see com.example.crudrepository.service.category.CategoryService#find(java.lang.String)
	 */
	
	/**
     * Selects a category by id.
     *
     * @param categorytId
     * @return found category
	 * @throws EntityNotFoundException 
     */
	@Override
	public Category find(String categorytId) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return findCategoryChecked(categorytId);
	}

	/* (non-Javadoc)
	 * @see com.example.crudrepository.service.category.CategoryService#create(com.example.crudrepository.model.Category)
	 */
	
	/**
     * Creates a new category.
     *
     * @param category
     * @return
     * @throws ConstraintsViolationException if any constraint is violated, ... .
     */
	@Override
	public Category create(Category category) throws ConstraintsViolationException {
		// TODO Auto-generated method stub
		Category newCategory;
		try {
			newCategory = categoryRepository.save(category);
		} catch (DataIntegrityViolationException e) {
			LOG.warn("ConstraintsViolationException while creating a category: {}", category, e);
            throw new ConstraintsViolationException(e.getMessage());
		}
		
		return newCategory;
	}
}
