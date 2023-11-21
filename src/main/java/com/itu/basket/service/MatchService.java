package com.itu.basket.service;

import com.itu.basket.model.Match;
import com.itu.basket.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository MatchRepository;

    public List<Match> getAllMatchs() {
        return MatchRepository.findAll();
    }

    public Match getMatchById(Long id) {
        Optional<Match> Match = MatchRepository.findById(id);
        return Match.orElse(null);
    }

    public Match createMatch(Match Match) {
        return MatchRepository.save(Match);
    }

    public Match updateMatch(Long id, Match Match) {
        Optional<Match> MatchData = MatchRepository.findById(id);
        if (MatchData.isPresent()) {
            Match updatedMatch = MatchData.get();
            updatedMatch = Match;
            return MatchRepository.save(updatedMatch);
        } else {
            return null;
        }
    }

    public void deleteMatch(Long id) {
        MatchRepository.deleteById(id);
    }
}