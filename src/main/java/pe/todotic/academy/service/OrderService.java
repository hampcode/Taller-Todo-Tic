package pe.todotic.academy.service;

import org.springframework.stereotype.Service;
import pe.todotic.academy.dto.OrderRequest;
import pe.todotic.academy.model.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {
    public Order createOrder(OrderRequest orderRequest) {

        return Order.builder()
                .accountId(orderRequest.getAccountId())
                .orderId("9999")
                .status("PENDING")
                .totalAmount(100.00)
                .totalTax(10.00)
                .transactionDate(LocalDate.now())
                .build();
    }

    public List<Order> findAllOrders() {
        List<Order> orders = new ArrayList<>();

        Order order01 = Order.builder()
                .accountId("999819")
                .orderId("11123")
                .status("PENDING")
                .totalAmount(100.00)
                .totalTax(10.00)
                .transactionDate(LocalDate.now())
                .build();

        Order order02 = Order.builder()
                .accountId("999819")
                .orderId("11124")
                .status("PENDING")
                .totalAmount(120.00)
                .totalTax(12.00)
                .transactionDate(LocalDate.now())
                .build();

        orders.add(order01);
        orders.add(order02);

        return orders;

    }

    public Order findOrderById(String orderId) {
       return Order.builder()
               .accountId("999819")
               .orderId(orderId)
               .status("PENDING")
               .totalAmount(100.00)
               .totalTax(10.00)
               .transactionDate(LocalDate.now())
               .build();
    }
}