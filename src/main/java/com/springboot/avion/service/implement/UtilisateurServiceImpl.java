package com.springboot.avion.service.implement;

import com.springboot.avion.repository.UtilisateurRep;
import com.springboot.avion.model.Utilisateur;
import com.springboot.avion.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    UtilisateurRep utilisateurRep;


    public Utilisateur findByEmailAndMdp(String email, String mdp){
        Utilisateur user = utilisateurRep.findByEmailAndMdp(email,mdp);
        return  user;
    }

    public  void save(Utilisateur utilisateur){
        utilisateurRep.save(utilisateur);
    }

}
