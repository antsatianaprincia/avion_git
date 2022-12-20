package com.springboot.avion.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "kilometrage")
public class Kilometrage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkilometrage")
    private int idKilometrage;

   @ManyToOne
    @JoinColumn(name = "idavion")
    Avion idAvion;

   @Column(name = "datekm")
   Date dateKm;

   @Column(name = "debutkm")
    double debutKm;

   @Column(name = "finkm")
    double finKm;

}
