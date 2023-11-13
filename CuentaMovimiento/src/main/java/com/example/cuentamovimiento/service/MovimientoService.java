package com.example.cuentamovimiento.service;

import com.example.cuentamovimiento.model.Movimiento;
import com.example.cuentamovimiento.model.Cuenta;
import com.example.cuentamovimiento.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaService cuentaService;

    public List<Movimiento> listarMovimientos(){
        return movimientoRepository.findAll();
    }

    public Optional<Movimiento> obtenerMovimientoId(Long id){
        return movimientoRepository.findById(id);
    }

    @Transactional
    public Movimiento guardarMovimiento(Movimiento movimiento){
        Cuenta cuenta = cuentaService.obtenerCuentaId(movimiento.getCuenta().getId())
            .orElseThrow(() -> new RuntimeException("No se encontro la cuenta con id: " + movimiento.getCuenta().getId()));
        double nuevoSaldo = cuenta.getSaldoInicial() + movimiento.getValor();

        if (movimiento.getTipoMovimiento() == Movimiento.TipoMovimiento.RETIRO && nuevoSaldo <0){
            throw new RuntimeException("No se puede retirar mas de lo que tiene en la cuenta");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        cuentaService.guardarCuenta(cuenta);
        movimiento.setSaldoDespuesMovimiento(nuevoSaldo);
        return movimientoRepository.save(movimiento);

    }

    @Transactional
    public void eliminarMovimiento(Long id){
        movimientoRepository.deleteById(id);
    }

    @Transactional
    public Movimiento actualizarMovimiento(Long id, Double cantidad){
        Movimiento movimiento = obtenerMovimientoId(id).orElseThrow(() -> new RuntimeException("No se encontro el movimiento con id: " + id));
        movimiento.setSaldoDespuesMovimiento(movimiento.getSaldoDespuesMovimiento() + cantidad);
        return movimientoRepository.save(movimiento);
    }

}
