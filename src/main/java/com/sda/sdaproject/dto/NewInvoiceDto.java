package com.sda.sdaproject.dto;

import com.sda.sdaproject.type.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewInvoiceDto {
    private Integer id;
    private String invoiceNumber;
    private Integer buyerId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sellByDate;
    private Integer userId;
    private PaymentType paymentType;

}
