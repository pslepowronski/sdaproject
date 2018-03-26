package com.sda.sdaproject.entity;

import com.sda.sdaproject.type.PaymentType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "invoice_number")
    private String invoiceNumber;


    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "sell_by_date")
    private LocalDate sellByDate;


    @Enumerated(value = EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
