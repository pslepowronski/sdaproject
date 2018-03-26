package com.sda.sdaproject.entity;




import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal price;

    private String name;

    private Integer quantity;



}
