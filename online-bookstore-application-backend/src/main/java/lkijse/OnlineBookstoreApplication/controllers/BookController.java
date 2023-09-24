package lkijse.OnlineBookstoreApplication.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lkijse.OnlineBookstoreApplication.model.Book;
import lkijse.OnlineBookstoreApplication.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    // Create a new book
    /**
     * @param book
     * @return
     */
    @PostMapping
    public ResponseEntity<Book> createBook(@Validated @RequestBody Book book) {
        Book createdBook = bookRepository.save(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a book by ID
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Validated @RequestBody Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            // Update book fields here
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setCategory(updatedBook.getCategory());
            existingBook.setCategory(updatedBook.getCategory());
            Book savedBook = bookRepository.save(existingBook);
            return new ResponseEntity<>(savedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
