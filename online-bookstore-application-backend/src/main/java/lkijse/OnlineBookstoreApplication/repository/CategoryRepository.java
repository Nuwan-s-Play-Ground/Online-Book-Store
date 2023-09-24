package lkijse.OnlineBookstoreApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lkijse.OnlineBookstoreApplication.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    Object getName();

    Object getDescription();

    Category save(Category newCategory);

    void deleteById(Long id);
    
}
