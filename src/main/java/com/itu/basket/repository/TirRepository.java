package com.itu.basket.repository;

import com.itu.basket.model.Tir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TirRepository extends JpaRepository<Tir, Long> {

}