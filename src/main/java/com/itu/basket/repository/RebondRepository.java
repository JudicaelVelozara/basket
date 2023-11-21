package com.itu.basket.repository;

import com.itu.basket.model.Rebond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RebondRepository extends JpaRepository<Rebond, Long> {

}