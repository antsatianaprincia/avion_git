package com.springboot.avion.service.implement;

import com.springboot.avion.repository.KilometrageRep;
import com.springboot.avion.model.Kilometrage;
import com.springboot.avion.service.KilometrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KilometrageServiceImpl implements KilometrageService {

    @Autowired
    KilometrageRep kilometrageRep;

    public void save (Kilometrage kilometrage){
        kilometrageRep.save(kilometrage);
    }

    public List<Kilometrage> findAll(){
        List<Kilometrage> listes = kilometrageRep.findAll();
        return listes;
    }

    public List<Kilometrage> getAllByIdKilometrage(int idKilometrage){
        List<Kilometrage> km = kilometrageRep.getAllByIdKilometrage(idKilometrage);
        return km;
    }



}
