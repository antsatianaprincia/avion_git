package com.springboot.avion.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "avion")
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idavion")
    private int idAvion;

    @ManyToOne
    @JoinColumn(name = "idmarque")
    Marque idMarque;

    @Column(name = "plaque")
    String plaque;


    public int getMoisAssuranceExpired(){

        return  0;
    }

}
