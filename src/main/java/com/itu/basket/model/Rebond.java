package com.itu.basket.model;

import lombok.*;
import jakarta.persistence.*;

@Data
@Entity
public class Rebond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDMATCH", referencedColumnName = "idmatch")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "IDJOUEUR", referencedColumnName = "idjoueur")
    private Joueur joueur;

    private Short type;

    // Autres attributs et relations si nécessaire
}