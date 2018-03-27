package com.sda.sdaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortInvoiceDto {
    private Integer buyerId;
    private List<Integer> productId;
    private List<Integer> quantity;
}
