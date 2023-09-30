package lkijse.OnlineBookstoreApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @Min(value = 0, message = "Price cannot be negative")
    private Double price;

    private String description;

    @NotBlank(message = "Category is required")
    private String category;

    private String subcategory;

    public int getQuantity() {
        return 0;
    }

    public void setQuantity(int i) {
    }

    public void setTitle(Object title2) {
    }

    public void setAuthor(Object author2) {
    }

    public void setPrice(Object price2) {
    }

    public void setDescription(Object description2) {
    }

    public void setCategory(Object category2) {
    }

    public void setSubcategory(Object subcategory2) {
    }

   
}
