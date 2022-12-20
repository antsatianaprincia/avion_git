package com.springboot.avion.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idutilisateur")
    private int idUtilisateur;

    @Column(name = "email")
    String email;

    @Column(name = "mdp")
    String mdp;

}
