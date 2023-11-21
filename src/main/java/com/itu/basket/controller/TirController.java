package com.itu.basket.controller;

import com.itu.basket.model.Tir;
import com.itu.basket.service.TirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tirs")
public class TirController {

    @Autowired
    private TirService tirService;

    @GetMapping
    public ResponseEntity<List<Tir>> getAllTirs() {
        List<Tir> tirs = tirService.getAllTirs();
        return new ResponseEntity<>(tirs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tir> getTirById(@PathVariable("id") Long id) {
        Tir tir = tirService.getTirById(id);
        if (tir != null) {
            return new ResponseEntity<>(tir, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Tir> createTir(@RequestBody Tir tir) {
        Tir createdTir = tirService.createTir(tir);
        return new ResponseEntity<>(createdTir, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tir> updateTir(@PathVariable("id") Long id, @RequestBody Tir tir) {
        Tir updatedTir = tirService.updateTir(id, tir);
        if (updatedTir != null) {
            return new ResponseEntity<>(updatedTir, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTir(@PathVariable("id") Long id) {
        tirService.deleteTir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}