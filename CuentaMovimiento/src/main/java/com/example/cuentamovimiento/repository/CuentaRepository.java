package com.example.cuentamovimiento.repository;
import com.example.cuentamovimiento.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{
}
