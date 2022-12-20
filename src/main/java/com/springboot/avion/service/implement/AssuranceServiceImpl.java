package com.springboot.avion.service.implement;

import com.springboot.avion.repository.AssuranceRep;
import com.springboot.avion.model.Assurance;
import com.springboot.avion.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    public List<Assurance> findAll(){
        return null;
    }

    public Assurance findById(int idAssurance){
        return null;
    }
    public void save(Assurance assurance){

    }

}
