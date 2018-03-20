package com.sda.sdaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceCriteriaDto {
    private String invoiceNumber;
    private LocalDate paymentDateFrom;
    private LocalDate paymentDateto;
    private LocalDate sellDatefrom;
    private LocalDate sellDateto;
    private String buyerName;
}
