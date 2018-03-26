package com.sda.sdaproject.config;


import com.sda.sdaproject.dto.ProductDto;
import com.sda.sdaproject.entity.Product;
import com.sda.sdaproject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductDto mapProduct(Product p){
        return ProductDto.builder()
                .id(p.getId())
                .name(p.getName())
                .price(p.getPrice())
                .quantity(p.getQuantity())
                .build();
    }

}
