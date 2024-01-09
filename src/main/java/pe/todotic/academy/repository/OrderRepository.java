package pe.todotic.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.academy.model.Order;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderId(String orderId);
}
