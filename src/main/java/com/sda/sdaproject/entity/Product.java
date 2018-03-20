package com.sda.sdaproject.entity;



import javax.persistence.*;
import java.math.BigDecimal;

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
