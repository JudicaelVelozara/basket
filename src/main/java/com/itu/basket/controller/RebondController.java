package com.itu.basket.controller;

import com.itu.basket.model.Rebond;
import com.itu.basket.service.RebondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rebonds")
public class RebondController {

    @Autowired
    private RebondService rebondService;

    @GetMapping
    public ResponseEntity<List<Rebond>> getAllRebonds() {
        List<Rebond> rebonds = rebondService.getAllRebonds();
        return new ResponseEntity<>(rebonds, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rebond> getRebondById(@PathVariable("id") Long id) {
        Rebond rebond = rebondService.getRebondById(id);
        if (rebond != null) {
            return new ResponseEntity<>(rebond, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Rebond> createRebond(@RequestBody Rebond rebond) {
        Rebond createdRebond = rebondService.createRebond(rebond);
        return new ResponseEntity<>(createdRebond, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rebond> updateRebond(@PathVariable("id") Long id, @RequestBody Rebond rebond) {
        Rebond updatedRebond = rebondService.updateRebond(id, rebond);
        if (updatedRebond != null) {
            return new ResponseEntity<>(updatedRebond, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRebond(@PathVariable("id") Long id) {
        rebondService.deleteRebond(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}