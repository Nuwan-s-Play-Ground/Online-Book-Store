package lkijse.OnlineBookstoreApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lkijse.OnlineBookstoreApplication.model.Subcategory;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    List<Subcategory> findAll();

    Optional<Subcategory> findById(Long id);

    void deleteById(Long id);

    Subcategory save(Subcategory existingSubcategory);

    Object getName();

    Object getDescription();
}