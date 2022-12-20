package com.springboot.avion.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtoken")
    private int idToken;

    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    private Utilisateur idUtilisateur;

    @Column(name = "valeur")
    private String valeur;

    @Column(name = "isvalable")
    private Boolean isValable;

    @Column(name = "dateexpiration")
    private LocalDateTime dateExpiration;


    public static String createToken(Utilisateur utilisateur){
        String token = null;
        LocalDateTime dateNow = LocalDateTime.now();
        String date = dateNow.toString();
        token = utilisateur.getEmail()+utilisateur.getMdp()+date;
        return token;
    }

    //Date et heure Expiration : defini pour 24h
    public static LocalDateTime f_dateExpiration(){
        LocalDateTime dateNow = LocalDateTime.now();
        Long hour = new Long("24");
        dateNow = dateNow.plusHours(hour);
        return dateNow;
    }


}
