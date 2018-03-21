package com.sda.sdaproject.bo;

import com.sda.sdaproject.dto.InvoiceCriteriaDto;
import com.sda.sdaproject.dto.InvoiceDto;
import com.sda.sdaproject.entity.Invoice;
import com.sda.sdaproject.repository.BuyerRepository;
import com.sda.sdaproject.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;
    private BuyerRepository buyerRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository, BuyerRepository buyerRepository){
        this.invoiceRepository=invoiceRepository;
        this.buyerRepository = buyerRepository;
    }

    public List<InvoiceDto> findByPaymentDateCriteria(InvoiceCriteriaDto c){
        return invoiceRepository.findByPaymentDateBetween(c.getPaymentDateFrom(),c.getPaymentDateto())
                .stream().map(this::InvoiceToDto).collect(Collectors.toList());
    }
    public List<InvoiceDto> findBySellDateCriteria(InvoiceCriteriaDto c){
        return invoiceRepository.findBySellByDateBetween(c.getSellDatefrom(),c.getSellDateto())
                .stream().map(this::InvoiceToDto).collect(Collectors.toList());
    }


    public InvoiceDto InvoiceToDto(Invoice i){
        return InvoiceDto.builder()
                .id(i.getId())
                .invoiceNumber(i.getInvoiceNumber())
                .paymentDate(i.getPaymentDate())
                .sellByDate(i.getSellByDate())
                .paymentType(i.getPaymentType())
                .buyerId(i.getBuyer().getId())
                .userId(i.getUser().getId())
                .build();
    }

    public List<InvoiceDto> findByAllCriteria(InvoiceCriteriaDto c){
        return invoiceRepository.findAll().stream().map(this::InvoiceToDto)
                .filter(i->i.getInvoiceNumber().contains(c.getInvoiceNumber())|| Objects.isNull(c.getInvoiceNumber()))
                .filter(i->i.getPaymentDate().isAfter(c.getPaymentDateFrom())|| Objects.isNull(c.getPaymentDateFrom()))
                .filter(i->i.getPaymentDate().isBefore(c.getPaymentDateto())|| Objects.isNull(c.getPaymentDateto()))
                .filter(i->i.getSellByDate().isAfter(c.getSellDatefrom())|| Objects.isNull(c.getSellDatefrom()))
                .filter(i->i.getPaymentDate().isBefore(c.getSellDateto())|| Objects.isNull(c.getSellDateto()))
                .collect(Collectors.toList());
    }

    public void deleteInvoice(Integer id){
        invoiceRepository.deleteById(id);
    }


}
