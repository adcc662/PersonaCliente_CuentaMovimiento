package com.example.personacliente.repository;

import com.example.personacliente.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface PersonaRepository extends JpaRepository<Persona, Long> {


}
