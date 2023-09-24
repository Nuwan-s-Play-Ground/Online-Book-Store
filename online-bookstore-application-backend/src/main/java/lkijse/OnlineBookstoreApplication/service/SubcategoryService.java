package lkijse.OnlineBookstoreApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lkijse.OnlineBookstoreApplication.model.Subcategory;
import lkijse.OnlineBookstoreApplication.repository.CategoryRepository;
import lkijse.OnlineBookstoreApplication.repository.SubcategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.Locale.Category;

@Service
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;

    public SubcategoryService(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    public Optional<Subcategory> getSubcategoryById(Long id) {
        return subcategoryRepository.findById(id);
    }

    public Subcategory createSubcategory(SubcategoryRepository subcategoryRequest) {
        // Find the parent category by ID
        Optional<Category> optionalCategory = categoryRepository.findById(subcategoryRequest.getCategoryId());
        if (!optionalCategory.isPresent()) {
            // Handle the case where the category is not found
            // You can throw a custom exception or return null/error response
            return null;
        }

        Category parentCategory = optionalCategory.get();

        // Create a new subcategory entity based on the request data
        Subcategory newSubcategory = new Subcategory();
        newSubcategory.setName(subcategoryRequest.getName());
        newSubcategory.setDescription(subcategoryRequest.getDescription());
        newSubcategory.setCategory(parentCategory);
        // Set other attributes as needed

        // Save the new subcategory to the database
        return subcategoryRepository.save(newSubcategory);
    }

    public Subcategory updateSubcategory(Long id, SubcategoryRepository subcategoryRequest) {
        // Find the subcategory by ID
        Optional<Subcategory> optionalSubcategory = subcategoryRepository.findById(id);
        if (!optionalSubcategory.isPresent()) {
            // Handle the case where the subcategory is not found
            // You can throw a custom exception or return null/error response
            return null;
        }

        // Find the parent category by ID
        Optional<Category> optionalCategory = categoryRepository.findById(subcategoryRequest.getCategoryId());
        if (!optionalCategory.isPresent()) {
            // Handle the case where the category is not found
            // You can throw a custom exception or return null/error response
            return null;
        }

        Category parentCategory = optionalCategory.get();
        Subcategory existingSubcategory = optionalSubcategory.get();

        // Update the subcategory entity with the new data from the request
        existingSubcategory.setName(subcategoryRequest.getName());
        existingSubcategory.setDescription(subcategoryRequest.getDescription());
        existingSubcategory.setCategory(parentCategory);
        // Update other attributes as needed

        // Save the updated subcategory to the database
        return subcategoryRepository.save(existingSubcategory);
    }

    public void deleteSubcategory(Long id) {
        subcategoryRepository.deleteById(id);
    }
}
