package com.open.coinoffline.service;

import com.open.coinoffline.domain.Category;
import com.open.coinoffline.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Category.
 */
@Service
@Transactional
public class CategoryService {

    private final Logger log = LoggerFactory.getLogger(CategoryService.class);

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Save a category.
     *
     * @param category the entity to save
     * @return the persisted entity
     */
    public Category save(Category category) {
        log.debug("Request to save Category : {}", category);
        return categoryRepository.save(category);
    }

    /**
     * Get all the categories.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Category> findAll(Pageable pageable) {
        log.debug("Request to get all Categories");
        return categoryRepository.findAll(pageable);
    }

    /**
     * Get one category by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Category findOne(Long id) {
        log.debug("Request to get Category : {}", id);
        return categoryRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the category by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Category : {}", id);
        categoryRepository.delete(id);
    }
}
