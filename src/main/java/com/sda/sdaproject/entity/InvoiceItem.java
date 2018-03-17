package com.sda.sdaproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "invoice_item")
public class InvoiceItem {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    private Integer quantity;

    private Integer sum;

    @Column(name = "invoice_id")
    private Integer invoiceId;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
