package com.springboot.avion.repository;

import com.springboot.avion.model.AssuranceAvion;
import com.springboot.avion.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssuranceAvionRep extends JpaRepository<AssuranceAvion, Integer> {

}
