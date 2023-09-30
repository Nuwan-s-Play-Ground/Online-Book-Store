package lkijse.OnlineBookstoreApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name is required")
    private String name;

    private String description;

    public void setName(Object name2) {
    }

    public void setDescription(Object description2) {
    }

    // Constructors, getters, setters
    
}
