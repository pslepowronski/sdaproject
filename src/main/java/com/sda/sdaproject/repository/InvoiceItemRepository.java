package com.sda.sdaproject.repository;

import com.sda.sdaproject.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Integer> {


    List<InvoiceItem> findInvoiceItemsByInvoice_Id(Integer id);
}
