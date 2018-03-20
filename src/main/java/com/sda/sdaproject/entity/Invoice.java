package com.sda.sdaproject.entity;

import com.sda.sdaproject.type.PaymentType;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Entity
@Table(name = "invoice")
public class
Invoice {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "sell_by_date")
    private LocalDate sellByDate;

    @Enumerated(value = EnumType.STRING)
    @Column(name ="payment_type")
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
