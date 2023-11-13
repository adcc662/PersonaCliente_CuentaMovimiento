package com.example.cuentamovimiento.service;

import com.example.cuentamovimiento.model.Cuenta;
import com.example.cuentamovimiento.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> listarCuentas(){
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> obtenerCuentaId(Long id){
        return cuentaRepository.findById(id);
    }

    @Transactional
    public Cuenta guardarCuenta(Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

    @Transactional
    public Cuenta actualizarCuenta(Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

    @Transactional
    public void eliminarCuenta(Long id){
        cuentaRepository.deleteById(id);
    }



}
