package com.example.cuentamovimiento.controller;

import com.example.cuentamovimiento.model.Movimiento;
import com.example.cuentamovimiento.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public ResponseEntity<List<Movimiento>> listarMovimientos(){
        return ResponseEntity.ok(movimientoService.listarMovimientos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> obtenerMovimiento(@PathVariable Long id){
        return movimientoService.obtenerMovimientoId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crearMovimiento(@RequestBody Movimiento movimiento){
        try {
            Movimiento nuevoMovimiento = movimientoService.guardarMovimiento(movimiento);
            return new ResponseEntity<>(nuevoMovimiento, HttpStatus.CREATED);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMovimiento(@PathVariable Long id){
        try{
            movimientoService.eliminarMovimiento(id);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarMovimiento(@PathVariable Long id, @RequestBody Movimiento movimiento){
        try{
            return movimientoService.obtenerMovimientoId(id)
                    .map(movimientoExistente -> {
                        return ResponseEntity.ok(movimientoService.guardarMovimiento(movimiento));
                    })
                    .orElse(ResponseEntity.notFound().build());
        } catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
