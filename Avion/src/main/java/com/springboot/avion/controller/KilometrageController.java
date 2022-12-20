package com.springboot.avion.controller;

import com.springboot.avion.model.Kilometrage;
import com.springboot.avion.service.KilometrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/kilometrages")
public class KilometrageController {

    @Autowired
    KilometrageService kilometrageService;

    @PostMapping("/kilometrage/create")
    public ResponseEntity<?> insertKilometrage(@RequestBody Kilometrage kilometrage){
        try {
            kilometrageService.save(kilometrage);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getKilometrage(){
        List<Kilometrage> kilometrageVal = null;
        try{
            kilometrageVal = kilometrageService.findAll();
            return  ResponseEntity.ok(kilometrageVal);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/kilometrage")
    public ResponseEntity<?> kilometrageAvion(@RequestBody Kilometrage kilometrage){
        List<Kilometrage> kilometrageVal = null;
        try{
            kilometrageVal = kilometrageService.getAllByIdKilometrage(kilometrage.getIdKilometrage());
            return  ResponseEntity.ok(kilometrageVal);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
