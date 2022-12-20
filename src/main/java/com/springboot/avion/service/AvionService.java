package com.springboot.avion.service;

import com.springboot.avion.model.Avion;

import java.util.List;


public interface AvionService {

    public Avion findById(int id);

    public List<Avion> findAll();

    public void save(Avion avion);

}
