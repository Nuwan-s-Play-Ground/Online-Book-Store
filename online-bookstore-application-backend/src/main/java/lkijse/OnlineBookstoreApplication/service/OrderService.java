package lkijse.OnlineBookstoreApplication.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.criteria.Order;
import lkijse.OnlineBookstoreApplication.dto.OrderRequest;
import lkijse.OnlineBookstoreApplication.entity.Book;
import lkijse.OnlineBookstoreApplication.repository.BookRepository;
import lkijse.OnlineBookstoreApplication.repository.OrderRepository;
import lkijse.OnlineBookstoreApplication.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    /**
     * @param orderRequest
     * @return
     */
    @Transactional
    public Order processOrder(OrderRequest orderRequest) {
        // Find the user by ID
        Optional<User> optionalUser = userRepository.findById(orderRequest.getUserId());
        if (!optionalUser.isPresent()) {
            // Handle the case where the user is not found
            // You can throw a custom exception or return null/error response
            return null;
        }

        User user = optionalUser.get();

        // Find the books by their IDs
        List<Book> orderedBooks = bookRepository.findAllById(orderRequest.getBookIds());

        // Calculate the total price of the order
        double total = calculateOrderTotal(orderedBooks);

        // Create a new order
        Order order = new Order();
        order.setUser(user);
        order.setItems(orderedBooks);
        order.setTotal(total);

        // Update book quantities and save the order
        updateBookQuantities(orderedBooks);
        return orderRepository.save(order);
    }

    private double calculateOrderTotal(List<Book> orderedBooks) {
        double total = 0.0;
        for (Book book : orderedBooks) {
            total += book.getPrice();
        }
        return total;
    }

    private void updateBookQuantities(List<Book> orderedBooks) {
        for (Book book : orderedBooks) {
            if (book.getQuantity() > 0) {
                book.setQuantity(book.getQuantity() - 1);
            }
        }
        bookRepository.saveAll(orderedBooks);
    }
}

