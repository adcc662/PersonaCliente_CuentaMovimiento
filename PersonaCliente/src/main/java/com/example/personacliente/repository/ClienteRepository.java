package com.example.personacliente.repository;
import com.example.personacliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
