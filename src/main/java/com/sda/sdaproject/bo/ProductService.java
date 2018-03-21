package com.sda.sdaproject.bo;

import com.sda.sdaproject.dto.ProductDto;
import com.sda.sdaproject.entity.Product;
import com.sda.sdaproject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    private Product productFromDto(ProductDto p){
        return Product.builder()
                .id(p.getId())
                .name(p.getName())
                .price(p.getPrice())
                .quantity(p.getQuantity())
                .build();
    }

    private List<Product> findAll(){
        return productRepository.findAll();
    }

    private void addProduct(ProductDto productDto){
        productRepository.save(productFromDto(productDto));
    }

    private void deleteProductById(Integer id){
        productRepository.delete(id);
    }
}
