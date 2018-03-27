package com.sda.sdaproject.bo;

import com.sda.sdaproject.dto.*;
import com.sda.sdaproject.entity.*;
import com.sda.sdaproject.repository.*;
import com.sda.sdaproject.type.PaymentType;
import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;
    private BuyerRepository buyerRepository;
    private UserRepository userRepository;
    private InvoiceItemRepository invoiceItemRepository;
    private ProductRepository productRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository, BuyerRepository buyerRepository, UserRepository userRepository,
                          InvoiceItemRepository invoiceItemRepository, ProductRepository productRepository){
        this.invoiceRepository = invoiceRepository;
        this.buyerRepository = buyerRepository;
        this.userRepository = userRepository;
        this.invoiceItemRepository = invoiceItemRepository;
        this.productRepository = productRepository;
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
        for(InvoiceItem iItem : invoiceItemRepository.findAll()){
            if(iItem.getInvoice().getId()==id){
                invoiceItemRepository.delete(iItem.getId());
            }
        }
        invoiceRepository.deleteById(id);
    }

    public FullInvoiceDto mapFullInvoice(Invoice i){
        return FullInvoiceDto.builder()
                .id(i.getId())
                .invoiceNumber(i.getInvoiceNumber())
                .paymentDate(i.getPaymentDate())
                .sellByDate(i.getSellByDate())
                .buyer(i.getBuyer())
                .user(i.getUser())
                .invoiceItems(findListOfInvoiceItemsByInvoiceId(i.getId()))
                .invoiceSum(getSumofInvoice(i.getId()))
                .build();
    }

    private InvoiceItemDto mapIIToIIDto(InvoiceItem ii){
        return InvoiceItemDto.builder()
                .id(ii.getId())
                .invoice(ii.getInvoice())
                .product(ii.getProduct())
                .sum(ii.getSum())
                .build();
    }

    private List<InvoiceItemDto> findListOfInvoiceItemsByInvoiceId(Integer id){
        return invoiceItemRepository.findInvoiceItemsByInvoice_Id(id).stream()
                .map(this::mapIIToIIDto).collect(Collectors.toList());
    }

    private BigDecimal getSumofInvoice(Integer id){
        List<InvoiceItemDto> invoiceItemDtosList = findListOfInvoiceItemsByInvoiceId(id);
        BigDecimal sum = new BigDecimal(0);
        for (InvoiceItemDto itemDto : invoiceItemDtosList){
            sum = sum.add(itemDto.getSum());
        }
        if(invoiceRepository.findById(id).getPaymentType().equals(PaymentType.CREDIT1M)){
            sum=sum.multiply(new BigDecimal(1.1));
        }else if(invoiceRepository.findById(id).getPaymentType().equals(PaymentType.CREDIT3M)){
            sum = sum.multiply(new BigDecimal(1.3));
        }
        return sum;
    }

    public FullInvoiceDto findFullInvoiceById(Integer id){
       Invoice invoice = invoiceRepository.findById(id);
       return mapFullInvoice(invoice);
    }

    public List<InvoiceItemDto> findInvoiceItemsToInvoice(ShortInvoiceDto shortInvoiceDto){
        List<InvoiceItemDto> newList = new ArrayList<>();
        List<Integer> listId = shortInvoiceDto.getProductId();
        List<Integer> listQuantity = shortInvoiceDto.getQuantity();
        for (Integer s : listQuantity){
            if (s==0||s==null){
                listId.remove(listQuantity.indexOf(s));
                listQuantity.remove(s);
            }else{
                newList.add(InvoiceItemDto.builder()
                        .product(productRepository.findById(listId.get(listQuantity.indexOf(s))))
                        .quantity(s)
                        .sum(productRepository.findById(listId.get(listQuantity.indexOf(s))).getPrice().multiply(new BigDecimal(s)))
                        .build());
            }
        }
        return newList;
    }







}
