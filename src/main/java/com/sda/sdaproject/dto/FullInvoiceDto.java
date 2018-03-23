package com.sda.sdaproject.dto;

import com.sda.sdaproject.entity.Buyer;
import com.sda.sdaproject.entity.User;
import com.sda.sdaproject.type.PaymentType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FullInvoiceDto {
    private Integer id;
    private String invoiceNumber;
    private Buyer buyer;
    private LocalDate paymentDate;
    private LocalDate sellByDate;
    private User user;
    private PaymentType paymentType;
    private List<InvoiceItemDto> invoiceItems;
    private BigDecimal invoiceSum;
}
