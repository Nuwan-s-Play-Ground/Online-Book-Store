package lkijse.OnlineBookstoreApplication.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lkijse.OnlineBookstoreApplication.entity.Book;
import lkijse.OnlineBookstoreApplication.repository.BookRepository;
import lkijse.OnlineBookstoreApplication.repository.BookRequest;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(BookRequest bookRequest) {
        // Create a new book entity based on the request data
        Book newBook = new Book();
        newBook.setTitle(bookRequest.getTitle());
        newBook.setAuthor(bookRequest.getAuthor());
        newBook.setPrice(bookRequest.getPrice());
        newBook.setDescription(bookRequest.getDescription());
        newBook.setCategory(bookRequest.getCategory());
        newBook.setSubcategory(bookRequest.getSubcategory());
        // Set other attributes as needed

        // Save the new book to the database
        return bookRepository.save(newBook);
    }

    public Book updateBook(Long id, BookRequest bookRequest) {
        // Find the book by ID
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (!optionalBook.isPresent()) {
            // Handle the case where the book is not found
            // You can throw a custom exception or return null/error response
            return null;
        }

        // Update the book entity with the new data from the request
        Book existingBook = optionalBook.get();
        existingBook.setTitle(bookRequest.getTitle());
        existingBook.setAuthor(bookRequest.getAuthor());
        existingBook.setPrice(bookRequest.getPrice());
        existingBook.setDescription(bookRequest.getDescription());
        existingBook.setCategory(bookRequest.getCategory());
        existingBook.setSubcategory(bookRequest.getSubcategory());
        // Update other attributes as needed

        // Save the updated book to the database
        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
