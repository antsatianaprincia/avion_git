package com.springboot.avion.controller;

import com.springboot.avion.repository.TokenRep;
import com.springboot.avion.model.Token;
import com.springboot.avion.model.Utilisateur;
import com.springboot.avion.service.TokenService;
import com.springboot.avion.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    UtilisateurService  utilisateurService;
    @Autowired
    TokenService tokenService;

    @Autowired
    TokenRep tokenRep;



    @PostMapping("/login")
    public ResponseEntity<Token> log(@RequestBody Utilisateur utilisateur){
        try{
            Utilisateur user = utilisateurService.findByEmailAndMdp(utilisateur.getEmail(), utilisateur.getMdp());

            Token token = new Token();
            token.setIdUtilisateur(user);
            String valeurs = Token.createToken(user);
            token.setValeur(valeurs);
            token.setIsValable(true);

            //Devra à nouveau se connecter après 24h car la dateExpiration est après 24h
            LocalDateTime dateExp = Token.f_dateExpiration();

            token.setDateExpiration(dateExp);
            Token generateToken = tokenService.save(token);
            Token t = tokenRep.getById(generateToken.getIdToken());

            return ResponseEntity.ok(generateToken);
        }

        catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/logOut")
    public void logOut(@RequestBody Token token){
        try {
            tokenService.deconnexion(token);
            ResponseEntity.ok("ok");
        }
        catch (Exception e){
            new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user/create")
    public void insertUser (@RequestBody Utilisateur utilisateur){
        try{
           utilisateurService.save(utilisateur);
        }

        catch (Exception e){
            new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
