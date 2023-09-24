package lkijse.OnlineBookstoreApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

import lkijse.OnlineBookstoreApplication.model.Book;

public interface BookRepository extends JpaRepositoryExtension<Book, Long> {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(Book newBook);

    void deleteById(Long id);

    List<Book> findAllById(Object bookIds);

    void saveAll(List<Book> orderedBooks);

    boolean existsById(Long id);
    
}