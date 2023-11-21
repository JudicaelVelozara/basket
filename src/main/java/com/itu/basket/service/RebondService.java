package com.itu.basket.service;

import com.itu.basket.model.Rebond;
import com.itu.basket.repository.RebondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RebondService {

    @Autowired
    private RebondRepository RebondRepository;

    public List<Rebond> getAllRebonds() {
        return RebondRepository.findAll();
    }

    public Rebond getRebondById(Long id) {
        Optional<Rebond> Rebond = RebondRepository.findById(id);
        return Rebond.orElse(null);
    }

    public Rebond createRebond(Rebond Rebond) {
        return RebondRepository.save(Rebond);
    }

    public Rebond updateRebond(Long id, Rebond Rebond) {
        Optional<Rebond> RebondData = RebondRepository.findById(id);
        if (RebondData.isPresent()) {
            Rebond updatedRebond = RebondData.get();
            updatedRebond = Rebond;
            return RebondRepository.save(updatedRebond);
        } else {
            return null;
        }
    }

    public void deleteRebond(Long id) {
        RebondRepository.deleteById(id);
    }
}