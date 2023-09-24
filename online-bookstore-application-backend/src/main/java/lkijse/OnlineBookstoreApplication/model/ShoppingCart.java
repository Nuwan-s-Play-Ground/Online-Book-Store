package lkijse.OnlineBookstoreApplication.model;

import java.util.List;

import org.apache.catalina.User;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "cart_books",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> items;

    public void setUser(User user2) {
    }

    public void setItems(List<Book> booksToAdd) {
    }

    public List<Book> getItems() {
        return null;
    }

    // Constructors, getters, setters
}
