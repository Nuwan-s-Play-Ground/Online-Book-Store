package lkijse.OnlineBookstoreApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lkijse.OnlineBookstoreApplication.entity.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findByUserId(Long userId);

    ShoppingCart save(ShoppingCart shoppingCart);
    
}
