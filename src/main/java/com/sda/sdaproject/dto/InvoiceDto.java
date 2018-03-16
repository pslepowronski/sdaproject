package com.sda.sdaproject.dto;

import com.sda.sdaproject.type.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private Integer id;
    private String invoiceNumber;
    private Integer buyerId;
    private LocalDate paymentDate;
    private LocalDate sellByDate;
    private Integer userId;
    private PaymentType paymentType;

}
