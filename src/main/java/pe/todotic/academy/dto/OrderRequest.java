package pe.todotic.academy.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private String accountId;
    private Double totalAmount;
    private Double totalTax;
}