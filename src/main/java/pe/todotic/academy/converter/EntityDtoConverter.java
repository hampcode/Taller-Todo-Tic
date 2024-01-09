package pe.todotic.academy.converter;

import org.springframework.stereotype.Component;
import pe.todotic.academy.dto.OrderResponse;
import pe.todotic.academy.model.Order;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    public OrderResponse convertEntityToDto(Order order) {
        return new OrderResponse(
                order.getOrderId(),
                order.getStatus(),
                order.getAccountId(),
                order.getTotalAmount(),
                order.getTotalTax(),
                order.getTransactionDate()
        );
    }

    public List<OrderResponse> convertEntityToDto(List<Order> orders) {
        return orders.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
}
