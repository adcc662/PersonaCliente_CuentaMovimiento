package com.example.cuentamovimiento.repository;
import com.example.cuentamovimiento.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{
}
