package com.itu.basket.controller;

import com.itu.basket.model.PasseDecisive;
import com.itu.basket.service.PasseDecisiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passeDecisives")
public class PasseDecisiveController {

    @Autowired
    private PasseDecisiveService passeDecisiveService;

    @GetMapping
    public ResponseEntity<List<PasseDecisive>> getAllPasseDecisives() {
        List<PasseDecisive> passeDecisives = passeDecisiveService.getAllPasseDecisives();
        return new ResponseEntity<>(passeDecisives, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasseDecisive> getPasseDecisiveById(@PathVariable("id") Long id) {
        PasseDecisive passeDecisive = passeDecisiveService.getPasseDecisiveById(id);
        if (passeDecisive != null) {
            return new ResponseEntity<>(passeDecisive, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PasseDecisive> createPasseDecisive(@RequestBody PasseDecisive passeDecisive) {
        PasseDecisive createdPasseDecisive = passeDecisiveService.createPasseDecisive(passeDecisive);
        return new ResponseEntity<>(createdPasseDecisive, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PasseDecisive> updatePasseDecisive(@PathVariable("id") Long id, @RequestBody PasseDecisive passeDecisive) {
        PasseDecisive updatedPasseDecisive = passeDecisiveService.updatePasseDecisive(id, passeDecisive);
        if (updatedPasseDecisive != null) {
            return new ResponseEntity<>(updatedPasseDecisive, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePasseDecisive(@PathVariable("id") Long id) {
        passeDecisiveService.deletePasseDecisive(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}