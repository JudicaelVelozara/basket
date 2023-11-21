package com.itu.basket.repository;

import com.itu.basket.model.Remplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemplacementRepository extends JpaRepository<Remplacement, Long> {

}