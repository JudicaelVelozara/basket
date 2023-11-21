package com.itu.basket.repository;

import com.itu.basket.model.PasseDecisive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasseDecisiveRepository extends JpaRepository<PasseDecisive, Long> {

}