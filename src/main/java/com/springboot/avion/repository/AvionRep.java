package com.springboot.avion.repository;

import com.springboot.avion.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRep extends JpaRepository<Avion, Integer> {

}
