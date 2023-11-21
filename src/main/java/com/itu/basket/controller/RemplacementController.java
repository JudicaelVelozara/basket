package com.itu.basket.controller;

import com.itu.basket.model.Remplacement;
import com.itu.basket.service.RemplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remplacements")
public class RemplacementController {

    @Autowired
    private RemplacementService remplacementService;

    @GetMapping
    public ResponseEntity<List<Remplacement>> getAllRemplacements() {
        List<Remplacement> remplacements = remplacementService.getAllRemplacements();
        return new ResponseEntity<>(remplacements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Remplacement> getRemplacementById(@PathVariable("id") Long id) {
        Remplacement remplacement = remplacementService.getRemplacementById(id);
        if (remplacement != null) {
            return new ResponseEntity<>(remplacement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Remplacement> createRemplacement(@RequestBody Remplacement remplacement) {
        Remplacement createdRemplacement = remplacementService.createRemplacement(remplacement);
        return new ResponseEntity<>(createdRemplacement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Remplacement> updateRemplacement(@PathVariable("id") Long id, @RequestBody Remplacement remplacement) {
        Remplacement updatedRemplacement = remplacementService.updateRemplacement(id, remplacement);
        if (updatedRemplacement != null) {
            return new ResponseEntity<>(updatedRemplacement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemplacement(@PathVariable("id") Long id) {
        remplacementService.deleteRemplacement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}