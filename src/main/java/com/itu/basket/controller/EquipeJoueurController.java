package com.itu.basket.controller;

import com.itu.basket.model.EquipeJoueur;
import com.itu.basket.service.EquipeJoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipeJoueurs")
public class EquipeJoueurController {

    @Autowired
    private EquipeJoueurService equipeJoueurService;

    @GetMapping
    public ResponseEntity<List<EquipeJoueur>> getAllEquipeJoueurs() {
        List<EquipeJoueur> equipeJoueurs = equipeJoueurService.getAllEquipeJoueurs();
        return new ResponseEntity<>(equipeJoueurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipeJoueur> getEquipeJoueurById(@PathVariable("id") Long id) {
        EquipeJoueur equipeJoueur = equipeJoueurService.getEquipeJoueurById(id);
        if (equipeJoueur != null) {
            return new ResponseEntity<>(equipeJoueur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EquipeJoueur> createEquipeJoueur(@RequestBody EquipeJoueur equipeJoueur) {
        EquipeJoueur createdEquipeJoueur = equipeJoueurService.createEquipeJoueur(equipeJoueur);
        return new ResponseEntity<>(createdEquipeJoueur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipeJoueur> updateEquipeJoueur(@PathVariable("id") Long id, @RequestBody EquipeJoueur equipeJoueur) {
        EquipeJoueur updatedEquipeJoueur = equipeJoueurService.updateEquipeJoueur(id, equipeJoueur);
        if (updatedEquipeJoueur != null) {
            return new ResponseEntity<>(updatedEquipeJoueur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipeJoueur(@PathVariable("id") Long id) {
        equipeJoueurService.deleteEquipeJoueur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}