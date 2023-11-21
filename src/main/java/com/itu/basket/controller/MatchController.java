package com.itu.basket.controller;

import com.itu.basket.model.Match;
import com.itu.basket.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matchs")
public class MatchController {

    @Autowired
    private MatchService MatchService;

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatchs() {
        List<Match> Matchs = MatchService.getAllMatchs();
        return new ResponseEntity<>(Matchs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable("id") Long id) {
        Match Match = MatchService.getMatchById(id);
        if (Match != null) {
            return new ResponseEntity<>(Match, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match Match) {
        Match createdMatch = MatchService.createMatch(Match);
        return new ResponseEntity<>(createdMatch, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable("id") Long id, @RequestBody Match Match) {
        Match updatedMatch = MatchService.updateMatch(id, Match);
        if (updatedMatch != null) {
            return new ResponseEntity<>(updatedMatch, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable("id") Long id) {
        MatchService.deleteMatch(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}