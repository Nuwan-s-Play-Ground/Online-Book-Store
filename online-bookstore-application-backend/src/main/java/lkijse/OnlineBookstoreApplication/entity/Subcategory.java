package lkijse.OnlineBookstoreApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Subcategory name is required")
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public void setName(Object name2) {
    }

    public void setDescription(Object description2) {
    }

    public void setCategory(java.util.Locale.Category parentCategory) {
    }

    // Constructors, getters, setters
}
