package com.itu.basket.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@Entity
public class Match {
    @Id
    private Long idMatch;

    @ManyToOne
    @JoinColumn(name = "IDEQUIPE_EXTERIEUR", referencedColumnName = "ID_EQUIPE")
    private Equipe equipeExterieur;

    @ManyToOne
    @JoinColumn(name = "IDEQUIPE_DOMICILE", referencedColumnName = "ID_EQUIPE")
    private Equipe equipeDomicile;

    @Column(name = "DEBUT")
    private Date debut;
}