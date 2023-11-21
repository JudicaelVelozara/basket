package com.itu.basket.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class EquipeJoueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "IDEQUIPE", referencedColumnName = "idEquipe")
    private Equipe equipe;

    @ManyToOne
    @JoinColumn(name = "IDJOUEUR", referencedColumnName = "idJoueur")
    private Joueur joueur;

    private Integer numero;

    private String poste;

}