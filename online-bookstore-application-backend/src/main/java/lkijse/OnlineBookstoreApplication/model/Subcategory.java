package lkijse.OnlineBookstoreApplication.model;

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
