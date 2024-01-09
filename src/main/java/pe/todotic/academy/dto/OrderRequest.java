package pe.todotic.academy.dto;

public record OrderRequest(
        String accountId,
        Double totalAmount,
        Double totalTax
) {}
