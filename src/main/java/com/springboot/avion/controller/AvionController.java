package com.springboot.avion.controller;



import com.springboot.avion.model.Avion;
import com.springboot.avion.service.AvionService;
import com.springboot.avion.utile.MyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/avions")
public class AvionController {
    @Autowired
    AvionService avionService;

    @GetMapping
    public ResponseEntity<?> getListe(){

            List<Avion> v = null;
            MyJson mj = new MyJson();
            try {
                v =avionService.findAll();

                mj.setData(v);
            }
            catch (Exception e)
            {
                mj.setError(e);
            }
            return ResponseEntity.ok(mj);
    }

    @GetMapping("{id}")
    public ResponseEntity<Avion> getAvion(@PathVariable ("id") int idAvion){
        Avion avionVal = null;
        try{
            avionVal = avionService.findById(idAvion);
            return  ResponseEntity.ok(avionVal);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public  ResponseEntity<Avion> insertAvion(@RequestBody Avion avion) {
        try {
            avionService.save(avion);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}





