package com.sda.sdaproject.config;

import com.sda.sdaproject.dto.BuyerCriteriaDto;
import com.sda.sdaproject.dto.BuyerDto;
import com.sda.sdaproject.entity.Buyer;
import com.sda.sdaproject.dto.NewBuyerDto;
import com.sda.sdaproject.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BuyerService {

    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public BuyerDto mapBuyer(Buyer b) {
        return BuyerDto.builder()
                .id(b.getId())
                .firstName(b.getFirstName())
                .lastName(b.getLastName())
                .taxNumber(b.getTaxNumber())
                .companyName(b.getCompanyName())
                .street(b.getStreet())
                .streetNumber(b.getStreetNumber())
                .postcode(b.getPostcode())
                .city(b.getCity())
                .build();
    }

    public List<BuyerDto> findByAllCriteria(BuyerCriteriaDto c) {
        return buyerRepository.findAll().stream().map(this::mapBuyer)
                .filter(b -> b.getFirstName().contains(c.getFirstName()) || Objects.isNull(c.getFirstName()))
                .filter(b -> b.getLastName().contains(c.getLastName()) || Objects.isNull(c.getLastName()))
                .filter(b -> b.getCompanyName().contains(c.getCompanyName()) || Objects.isNull(c.getCompanyName()))
                .filter(b -> b.getCity().contains(c.getCity()) || Objects.isNull(c.getCity()))
                .collect(Collectors.toList());
    }

    public void deleteBuyer(Integer id) {
        buyerRepository.delete(id);
    }


    public BuyerDto findCostDetails(Integer id) {
        return Optional.ofNullable(buyerRepository.findOne(id))
                .map(this::mapBuyer)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<BuyerDto> findBuyers() {
        return buyerRepository.findAll()
                .stream()
                .map(this::mapBuyer)
                .collect(Collectors.toList());
    }

    public void addBuyer(NewBuyerDto buyer){
        buyerRepository.save(getBuyerFromDto(buyer));
    }

    private Buyer getBuyerFromDto(NewBuyerDto buyer) {
        return Buyer.builder()
                .firstName(buyer.getFirstName())
                .lastName(buyer.getLastName())
                .companyName(buyer.getCompanyName())
                .taxNumber(buyer.getTaxNumber())
                .street(buyer.getStreet())
                .streetNumber(buyer.getStreetNumber())
                .postcode(buyer.getPostcode())
                .city(buyer.getCity())
                .id(buyer.getId())
                .build();
    }
}
