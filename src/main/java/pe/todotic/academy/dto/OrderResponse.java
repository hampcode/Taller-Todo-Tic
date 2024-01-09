package pe.todotic.academy.dto;

import java.time.LocalDate;

public record OrderResponse(
        String orderId,
        String status,
        String accountId,
        Double totalAmount,
        Double totalTax,
        LocalDate transactionDate
) {}