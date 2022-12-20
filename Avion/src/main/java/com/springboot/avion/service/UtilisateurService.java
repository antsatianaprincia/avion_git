package com.springboot.avion.service;

import com.springboot.avion.model.Utilisateur;

public interface UtilisateurService{

    public Utilisateur findByEmailAndMdp(String email, String mdp);

    public void save(Utilisateur utilisateur);
}
