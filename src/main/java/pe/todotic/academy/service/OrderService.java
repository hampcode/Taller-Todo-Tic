package pe.todotic.academy.service;

import org.springframework.stereotype.Service;
import pe.todotic.academy.dto.OrderRequest;
import pe.todotic.academy.model.Order;
import pe.todotic.academy.repository.OrderRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderRequest orderRequest) {

        Order order = Order.builder()
                .accountId(orderRequest.getAccountId())
                .status("PENDING")
                .totalAmount(orderRequest.getTotalAmount())
                .totalTax(orderRequest.getTotalTax())
                .transactionDate(LocalDate.now())
                .build();

        return orderRepository.save(order);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order findOrderById(String orderId) {
        return orderRepository.findByOrderId(orderId).orElse(null);
    }


    public Optional<Order> updateOrder(String orderId, OrderRequest orderRequest) {
        return orderRepository.findByOrderId(orderId).map(existingOrder -> {

            existingOrder.setAccountId(orderRequest.getAccountId());
            existingOrder.setTotalAmount(orderRequest.getTotalAmount());
            existingOrder.setTotalTax(orderRequest.getTotalTax());
            return orderRepository.save(existingOrder);
        });
    }

    public void deleteOrder(String orderId) {
        orderRepository.findByOrderId(orderId).ifPresent(orderRepository::delete);
    }
}