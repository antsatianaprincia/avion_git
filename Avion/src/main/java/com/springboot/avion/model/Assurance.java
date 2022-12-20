package com.springboot.avion.model;

import com.springboot.avion.service.AvionService;
import com.springboot.avion.service.implement.AvionServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Assurance")
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idassurance")
    private int idAssurance;

    @Column(name = "nomassurance")
    String nomAssurance;

    @Column(name = "montant")
    Double montant;



}
