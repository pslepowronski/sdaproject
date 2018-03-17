package com.sda.sdaproject.entity;




import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    private BigDecimal price;

    private String name;

    private Integer quantity;



}
