package com.springboot.avion.service.implement;

import com.springboot.avion.model.Avion;
import com.springboot.avion.repository.AvionRep;
import com.springboot.avion.service.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvionServiceImpl implements AvionService {
    @Autowired
    AvionRep avionRep;

    public Avion findById(int id){
        Avion avions = avionRep.findById(id).get();
        return avions;
    }

    public List<Avion> findAll(){
        List<Avion> avions = avionRep.findAll();
        return avions;
    }

    public void save(Avion avion){
        avionRep.save(avion);
    }



}
