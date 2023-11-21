package com.itu.basket.service;

import com.itu.basket.model.PasseDecisive;
import com.itu.basket.repository.PasseDecisiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasseDecisiveService {

    @Autowired
    private PasseDecisiveRepository PasseDecisiveRepository;

    public List<PasseDecisive> getAllPasseDecisives() {
        return PasseDecisiveRepository.findAll();
    }

    public PasseDecisive getPasseDecisiveById(Long id) {
        Optional<PasseDecisive> PasseDecisive = PasseDecisiveRepository.findById(id);
        return PasseDecisive.orElse(null);
    }

    public PasseDecisive createPasseDecisive(PasseDecisive PasseDecisive) {
        return PasseDecisiveRepository.save(PasseDecisive);
    }

    public PasseDecisive updatePasseDecisive(Long id, PasseDecisive PasseDecisive) {
        Optional<PasseDecisive> PasseDecisiveData = PasseDecisiveRepository.findById(id);
        if (PasseDecisiveData.isPresent()) {
            PasseDecisive updatedPasseDecisive = PasseDecisiveData.get();
            updatedPasseDecisive = PasseDecisive;
            return PasseDecisiveRepository.save(updatedPasseDecisive);
        } else {
            return null;
        }
    }

    public void deletePasseDecisive(Long id) {
        PasseDecisiveRepository.deleteById(id);
    }
}