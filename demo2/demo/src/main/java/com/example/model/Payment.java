package com.example.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Payment {
    private LocalDateTime creationTime;
    private BigDecimal sum;
}
