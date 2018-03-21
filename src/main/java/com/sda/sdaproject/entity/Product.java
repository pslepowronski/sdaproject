package com.sda.sdaproject.entity;



import lombok.Builder;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;



}
