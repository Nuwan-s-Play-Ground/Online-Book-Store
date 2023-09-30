package lkijse.OnlineBookstoreApplication.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lkijse.OnlineBookstoreApplication.entity.Category;
import lkijse.OnlineBookstoreApplication.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(CategoryRepository categoryRequest) {
        // Create a new category entity based on the request data
        Category newCategory = new Category();
        newCategory.setName(categoryRequest.getName());
        newCategory.setDescription(categoryRequest.getDescription());
        // Set other attributes as needed

        // Save the new category to the database
        return categoryRepository.save(newCategory);
    }

    public Category updateCategory(Long id, CategoryRepository categoryRequest) {
        // Find the category by ID
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()) {
            // Handle the case where the category is not found
            // You can throw a custom exception or return null/error response
            return null;
        }

        // Update the category entity with the new data from the request
        Category existingCategory = optionalCategory.get();
        existingCategory.setName(categoryRequest.getName());
        existingCategory.setDescription(categoryRequest.getDescription());
        // Update other attributes as needed

        // Save the updated category to the database
        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
