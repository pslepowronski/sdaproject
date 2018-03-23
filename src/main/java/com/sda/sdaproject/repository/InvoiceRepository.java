package com.sda.sdaproject.repository;

import com.sda.sdaproject.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    List<Invoice> findByPaymentDateBetween(LocalDate from, LocalDate to);
    List<Invoice> findBySellByDateBetween(LocalDate from, LocalDate to);
    void deleteById(Integer id);
    Invoice findInvoiceById(Integer id);
    Invoice findById(Integer id);

}
