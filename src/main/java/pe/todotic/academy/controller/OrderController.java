package pe.todotic.academy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.todotic.academy.dto.OrderRequest;
import pe.todotic.academy.dto.OrderResponse;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAllOrders() {
        List<OrderResponse> orderList = new ArrayList<>();

        OrderResponse response01 = OrderResponse.builder()
                .accountId("999819")
                .orderId("11123")
                .status("PENDING")
                .totalAmount(100.00)
                .totalTax(10.00)
                .transactionDate(LocalDate.now())
                .build();

        OrderResponse response02 = OrderResponse.builder()
                .accountId("999819")
                .orderId("11124")
                .status("PENDING")
                .totalAmount(120.00)
                .totalTax(12.00)
                .transactionDate(LocalDate.now())
                .build();

        orderList.add(response01);
        orderList.add(response02);

        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById (@PathVariable String orderId) {
        OrderResponse response = OrderResponse.builder()
                .accountId("999819")
                .orderId(orderId)
                .status("PENDING")
                .totalAmount(100.00)
                .totalTax(10.00)
                .transactionDate(LocalDate.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse response = OrderResponse.builder()
                .accountId(orderRequest.getAccountId())
                .orderId("9999")
                .status("PENDING")
                .totalAmount(100.00)
                .totalTax(10.00)
                .transactionDate(LocalDate.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}