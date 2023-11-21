package com.itu.basket.service;

import com.itu.basket.model.Joueur;
import com.itu.basket.repository.JoueurRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class JoueurService {

    @Autowired
    JoueurRepository joueurRepository;

    public Joueur ajouterJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public Optional<Joueur> obtenirJoueurParId(int id) {
        return joueurRepository.findById(id);
    }

    public List<Joueur> obtenirTousLesJoueurs() {
        return joueurRepository.findAll();
    }

    public Joueur mettreAJourJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public void supprimerJoueur(int id) {
        joueurRepository.deleteById(id);
    }
}