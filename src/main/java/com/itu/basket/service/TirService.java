package com.itu.basket.service;

import com.itu.basket.model.Tir;
import com.itu.basket.repository.TirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TirService {

    @Autowired
    private TirRepository TirRepository;

    public List<Tir> getAllTirs() {
        return TirRepository.findAll();
    }

    public Tir getTirById(Long id) {
        Optional<Tir> Tir = TirRepository.findById(id);
        return Tir.orElse(null);
    }

    public Tir createTir(Tir Tir) {
        return TirRepository.save(Tir);
    }

    public Tir updateTir(Long id, Tir Tir) {
        Optional<Tir> TirData = TirRepository.findById(id);
        if (TirData.isPresent()) {
            Tir updatedTir = TirData.get();
            updatedTir = Tir;
            return TirRepository.save(updatedTir);
        } else {
            return null;
        }
    }

    public void deleteTir(Long id) {
        TirRepository.deleteById(id);
    }
}