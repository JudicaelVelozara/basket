package com.itu.basket.controller;

import com.itu.basket.model.Joueur;
import com.itu.basket.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {

    @Autowired
    JoueurService joueurService;

    @PostMapping
    public ResponseEntity<Joueur> ajouterJoueur(@RequestBody Joueur joueur) {
        Joueur nouveauJoueur = joueurService.ajouterJoueur(joueur);
        return new ResponseEntity<>(nouveauJoueur, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joueur> obtenirJoueurParId(@PathVariable int id) {
        Optional<Joueur> joueur = joueurService.obtenirJoueurParId(id);
        return joueur.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Joueur>> obtenirTousLesJoueurs() {
        List<Joueur> joueurs = joueurService.obtenirTousLesJoueurs();
        if (!joueurs.isEmpty()) {
            return new ResponseEntity<>(joueurs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Joueur> mettreAJourJoueur(@PathVariable int id, @RequestBody Joueur joueur) {
        Optional<Joueur> joueurExistant = joueurService.obtenirJoueurParId(id);
        if (joueurExistant.isPresent()) {
            joueur.setIdJoueur(id);
            Joueur joueurMaj = joueurService.mettreAJourJoueur(joueur);
            return new ResponseEntity<>(joueurMaj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerJoueur(@PathVariable int id) {
        Optional<Joueur> joueur = joueurService.obtenirJoueurParId(id);
        if (joueur.isPresent()) {
            joueurService.supprimerJoueur(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}