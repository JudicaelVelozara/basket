package com.itu.basket.model;

import lombok.*;
import jakarta.persistence.*;

@Data
@Entity
public class PasseDecisive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDMATCH", referencedColumnName = "idMatch")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "IDJOUEUR", referencedColumnName = "idJoueur")
    private Joueur joueur;

}