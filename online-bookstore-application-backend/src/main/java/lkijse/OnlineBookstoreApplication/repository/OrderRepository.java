package lkijse.OnlineBookstoreApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.criteria.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order save(lkijse.OnlineBookstoreApplication.model.Order order);
}

