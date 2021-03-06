package com.sda.sdaproject.repository;

import com.sda.sdaproject.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

    Buyer findById(Integer id);
}
