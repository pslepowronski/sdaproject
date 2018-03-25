package com.sda.sdaproject.entity;



import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Getter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;



}
