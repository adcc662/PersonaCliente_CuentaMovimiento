package com.example.cuentamovimiento.controller;
import com.example.cuentamovimiento.model.Cuenta;
import com.example.cuentamovimiento.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {


    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<Cuenta>> listarCuentas(){
        return ResponseEntity.ok(cuentaService.listarCuentas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerCuenta(@PathVariable Long id){
        return cuentaService.obtenerCuentaId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody Cuenta cuenta){
        Cuenta nuevaCuenta = cuentaService.guardarCuenta(cuenta);
        return ResponseEntity.ok(nuevaCuenta);
    }

    @PutMapping("/{id}")
        public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta){
        return cuentaService.obtenerCuentaId(id)
                .map(cuentaActualizada -> {
                    cuentaActualizada.setNumeroCuenta(cuenta.getNumeroCuenta());
                    cuentaActualizada.setSaldoInicial(cuenta.getSaldoInicial());
                    cuentaActualizada.setTipoCuenta(cuenta.getTipoCuenta());
                    cuentaActualizada.setEstado(cuenta.getEstado());
                    return ResponseEntity.ok(cuentaService.guardarCuenta(cuentaActualizada));
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long id){
        cuentaService.eliminarCuenta(id);
        return ResponseEntity.ok().build();
    }



}
