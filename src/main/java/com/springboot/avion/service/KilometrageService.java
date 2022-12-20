package com.springboot.avion.service;

import com.springboot.avion.model.Kilometrage;

import java.util.List;

public interface KilometrageService {

    public void save (Kilometrage kilometrage);

    public List<Kilometrage> findAll();

    public List<Kilometrage> getAllByIdKilometrage(int idKilometrage);



}
