package com.springboot.avion.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "AssuranceAvion")
public class AssuranceAvion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idassuranceavion")
    int idassuranceavion  ;

    @Column(name = "idavion")
   int idavion;

    @Column(name = "idassurance")
   int idassurance;

    @Column(name ="datecreation")
   Date datecreation    ;

    @Column(name ="dateexpiration")
   Date dateexpiration   ;


}
