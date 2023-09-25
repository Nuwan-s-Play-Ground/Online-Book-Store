package lkijse.OnlineBookstoreApplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import lkijse.OnlineBookstoreApplication.dto.OrderRequest;
import lkijse.OnlineBookstoreApplication.model.Book;
import lkijse.OnlineBookstoreApplication.model.Order;
import lkijse.OnlineBookstoreApplication.repository.BookRepository;
import lkijse.OnlineBookstoreApplication.repository.OrderRepository;
import lkijse.OnlineBookstoreApplication.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @PostMapping("/process")
    public ResponseEntity<Order> processOrder(@RequestBody OrderRequest orderRequest) {
        // Validate and process the order
        Order processedOrder = processOrderInternal(orderRequest);

        if (processedOrder != null) {
            return new ResponseEntity<>(processedOrder, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private jakarta.persistence.criteria.Order processOrderInternal(OrderRequest orderRequest) {
        // Extract order details from orderRequest
        List<Long> bookIds = orderRequest.getBookIds();
        Long userId = orderRequest.getUserId();

        // Fetch user and books from the database
        User user = userRepository.findById(userId).orElse(null);
        List<Book> books = bookRepository.findAllById(bookIds);

        if (user == null || books.isEmpty()) {
            return null; // Invalid order request
        }

        // Calculate the total price of the order
        double total = calculateOrderTotal(books);

        // Update book quantities (decrementing the quantity of each book)
        updateBookQuantities(books);

        // Create an Order entity
        Order order = new Order();
        order.setUser(user);
        order.setItems(books);
        order.setTotal(total);

        // Save the order to the database
        return orderRepository.save(order);
    }

    private double calculateOrderTotal(List<Book> books) {
        double total = 0.0;
        for (Book book : books) {
            total += book.getPrice();
        }
        return total;
    }

    private void updateBookQuantities(List<Book> books) {
        for (Book book : books) {
            if (book.getQuantity() > 0) {
                book.setQuantity(book.getQuantity() - 1);
            }
        }
        bookRepository.saveAll(books);
    }
}
