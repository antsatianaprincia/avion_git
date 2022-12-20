package com.springboot.avion.repository;

import com.springboot.avion.model.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssuranceRep extends JpaRepository<Assurance, Integer> {
}
