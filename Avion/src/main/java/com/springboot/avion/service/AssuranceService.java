package com.springboot.avion.service;

import com.springboot.avion.model.Assurance;

import java.util.List;

public interface AssuranceService {

    public List<Assurance> findAll();

    public Assurance findById(int idAssurance);
    public void save(Assurance assurance);
}
