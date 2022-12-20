package com.springboot.avion.repository;

import com.springboot.avion.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRep extends JpaRepository<Utilisateur, Integer> {

    public Utilisateur findByEmailAndMdp(String email, String mdp);

}
