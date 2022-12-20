package com.springboot.avion.controller;

import com.springboot.avion.repository.TokenRep;
import com.springboot.avion.model.Token;
import com.springboot.avion.model.Utilisateur;
import com.springboot.avion.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin
@RequestMapping("/tokens")
public class TokenController {
    @Autowired
    TokenService tokenService;

    @Autowired
    TokenRep tokenRep;

    @PostMapping("/bearerToken")
    public ResponseEntity<?> bearerToken(@RequestBody Token token){
        try {
            boolean b = tokenService.bearerToken(token);

                return ResponseEntity.ok(b);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping("/token")
    public ResponseEntity<Token> get(@RequestBody Token token){
        try {
            System.out.println(token.getIdToken());
            Token t = tokenRep.getById(token.getIdToken());

                return ResponseEntity.ok(t);

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }



    @PostMapping("/token/create")
    public ResponseEntity<Token> createToken(@RequestBody Utilisateur user) {
        try {
            Token token = new Token();
            token.setIdUtilisateur(user);
            String valeurs = Token.createToken(user);
            token.setValeur(valeurs);
            token.setIsValable(true);
            LocalDateTime dateExp = Token.f_dateExpiration();

            token.setDateExpiration(dateExp);
            tokenService.save(token);

            return ResponseEntity.ok(token);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
