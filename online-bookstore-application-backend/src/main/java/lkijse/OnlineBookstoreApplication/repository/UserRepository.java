package lkijse.OnlineBookstoreApplication.repository;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    default Optional<User> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    User save(User newUser);

}