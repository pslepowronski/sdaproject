package com.sda.sdaproject.bo;

import com.sda.sdaproject.dto.ProductCriteriaDto;
import com.sda.sdaproject.dto.ProductDto;
import com.sda.sdaproject.entity.Product;
import com.sda.sdaproject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    private ProductDto dtoFromProduct(Product p){
        return ProductDto.builder()
                .id(p.getId())
                .name(p.getName())
                .price(p.getPrice())
                .quantity(p.getQuantity())
                .build();
    }

    public List<ProductDto> findAllProducts(){
//        return productRepository.findAll();
        return productRepository.findAll().stream().map(this::dtoFromProduct)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findByAllCriteria(ProductCriteriaDto c){
        return productRepository.findAll().stream().map(this::dtoFromProduct)
               .filter(i->i.getName().contains(c.getName())|| Objects.isNull(c.getName()))
                .filter(i->i.getPrice().compareTo(c.getPriceFrom()) < 0|| Objects.isNull(c.getPriceFrom()))
                .filter(i->i.getPrice().compareTo(c.getPriceTo()) > 0|| Objects.isNull(c.getPriceTo()))
                .filter(i->i.getQuantity()>=(c.getQuantityFrom())|| Objects.isNull(c.getQuantityFrom()))
                .filter(i->i.getQuantity()<=(c.getQuantityTo())|| Objects.isNull(c.getQuantityTo()))
                .collect(Collectors.toList());
    }

    public void addNewProduct(ProductDto productDto){
        Product p = productFromDto(productDto);
        productRepository.save(p);
    }
    public void complementProduct(Integer id, Integer quantity){
        Product p = productRepository.findById(id);
        ProductDto pdto = dtoFromProduct(p);
        pdto.setQuantity(pdto.getQuantity()+quantity);
        productRepository.delete(id);
        productRepository.save(productFromDto(pdto));
    }

    public void deleteProductById(Integer id){
        productRepository.delete(id);
    }
}
