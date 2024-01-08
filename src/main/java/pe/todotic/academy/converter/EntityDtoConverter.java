package pe.todotic.academy.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.todotic.academy.dto.OrderResponse;
import pe.todotic.academy.model.Order;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    private final ModelMapper modelMapper;

    public EntityDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OrderResponse convertEntityToDto(Order order) {
        return modelMapper.map(order, OrderResponse.class);
    }

    public List<OrderResponse> convertEntityToDto(List<Order> orders) {
        return orders.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
}