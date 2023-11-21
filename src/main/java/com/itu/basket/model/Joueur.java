package com.itu.basket.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Joueur {
    @Id
    int idJoueur;
    String nom;
    String prenom;
}
