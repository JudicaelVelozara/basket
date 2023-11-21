package com.itu.basket.model;

import lombok.*;
import jakarta.persistence.*;

import java.sql.Time;

@Data
@Entity
public class Remplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDMATCH", referencedColumnName = "idmatch")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "IDJOUEURA", referencedColumnName = "idjoueur")
    private Joueur joueurA;

    @ManyToOne
    @JoinColumn(name = "IDJOUEURB", referencedColumnName = "idjoueur")
    private Joueur joueurB;

    private Time heure;
}