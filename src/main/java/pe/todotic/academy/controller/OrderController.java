package pe.todotic.academy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.todotic.academy.dto.OrderRequest;
import pe.todotic.academy.dto.OrderResponse;
import pe.todotic.academy.model.Order;
import pe.todotic.academy.service.OrderService;
import pe.todotic.academy.converter.EntityDtoConverter;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final EntityDtoConverter converter;

    public OrderController(OrderService orderService, EntityDtoConverter converter) {
        this.orderService = orderService;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAllOrders() {
        List<Order> orders = orderService.findAllOrders();
        return new ResponseEntity<>(converter.convertEntityToDto(orders), HttpStatus.OK);
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById (@PathVariable String orderId) {
        Order order = orderService.findOrderById(orderId);
        return new ResponseEntity<>(converter.convertEntityToDto(order), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.createOrder(orderRequest);
        return new ResponseEntity<>(converter.convertEntityToDto(order), HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable String orderId, @RequestBody OrderRequest orderRequest) {
        return orderService.updateOrder(orderId, orderRequest)
                .map(converter::convertEntityToDto)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}