package lkijse.OnlineBookstoreApplication.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @Nonnull(message = "Price is required")
    @Min(value = 0, message = "Price cannot be negative")
    private Double price;

    private String description;

    @NotBlank(message = "Category is required")
    private String category;

    private String subcategory;

    public Object getTitle() {
        return null;
    }

    public void setTitle(Object title2) {
    }

    public Object getAuthor() {
        return null;
    }

    public void setAuthor(Object author2) {
    }

    public Object getPrice() {
        return null;
    }

    public void setPrice(Object price2) {
    }

    public Object getDescription() {
        return null;
    }

    public void setDescription(Object description2) {
    }

    public Object getCategory() {
        return null;
    }

    public void setCategory(Object category2) {
    }

    public int getQuantity() {
        return 0;
    }

    public void setQuantity(int i) {
    }

    // Constructors, getters, setters
}
