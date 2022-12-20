package com.springboot.avion.controller;

import com.springboot.avion.model.Assurance;
import com.springboot.avion.model.Avion;
import com.springboot.avion.service.AssuranceService;
import com.springboot.avion.utile.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/assurances")
public class AssuranceController {
    @Autowired
    AssuranceService assuranceService;

    @GetMapping
    public ResponseEntity<?> listeAssurance(){
        List<Assurance> assuranceVal = null;
        try{
            assuranceVal = assuranceService.findAll();
            return  ResponseEntity.ok(assuranceVal);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Assurance> getAssurance(@PathVariable("id") int idAssurance){
        Assurance AssuranceVal = null;
        try{
            AssuranceVal = assuranceService.findById(idAssurance);
            return  ResponseEntity.ok(AssuranceVal);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public  ResponseEntity<Assurance> insertAssurance(@RequestBody Assurance assurance) {
        try {
            assuranceService.save(assurance);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
