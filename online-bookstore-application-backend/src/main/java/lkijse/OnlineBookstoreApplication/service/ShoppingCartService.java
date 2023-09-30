package lkijse.OnlineBookstoreApplication.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lkijse.OnlineBookstoreApplication.entity.Book;
import lkijse.OnlineBookstoreApplication.entity.ShoppingCart;
import lkijse.OnlineBookstoreApplication.repository.AddToCartRequest;
import lkijse.OnlineBookstoreApplication.repository.BookRepository;
import lkijse.OnlineBookstoreApplication.repository.ShoppingCartRepository;
import lkijse.OnlineBookstoreApplication.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository cartRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository cartRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public Optional<ShoppingCart> getShoppingCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Transactional
    public ShoppingCart addToCart(Long userId, AddToCartRequest addToCartRequest) {
        // Find the user
        Optional<org.apache.catalina.User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            // Handle the case where the user is not found
            // You can throw a custom exception or return null/error response
            return null;
        }

        org.apache.catalina.User user = optionalUser.get();

        // Find the books by their IDs
        List<Book> booksToAdd = bookRepository.findAllById(addToCartRequest.getBookIds());

        // Create or update the shopping cart
        ShoppingCart shoppingCart = user.getShoppingCart();
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setUser(user);
            shoppingCart.setItems(booksToAdd);
        } else {
            shoppingCart.getItems().addAll(booksToAdd);
        }

        // Save the shopping cart
        return cartRepository.save(shoppingCart);
    }

    @Transactional
    public void removeFromCart(Long userId, Long bookId) {
        // Find the user and their shopping cart
        Optional<org.apache.catalina.User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            // Handle the case where the user is not found
            // You can throw a custom exception or return null/error response
            return;
        }

        org.apache.catalina.User user = optionalUser.get();
        ShoppingCart shoppingCart = user.getShoppingCart();

        if (shoppingCart != null) {
            // Remove the book with the given ID from the shopping cart
            shoppingCart.getItems().removeIf(book -> book.getId().equals(bookId));
            cartRepository.save(shoppingCart);
        }
    }
}
