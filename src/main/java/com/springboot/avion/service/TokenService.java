package com.springboot.avion.service;

import com.springboot.avion.model.Token;

public interface TokenService {
    public Token save(Token token);


    //Pour faire le controle des token si elles sont encore valide
    public Boolean bearerToken( Token token);

    public void deconnexion(Token token);


}
