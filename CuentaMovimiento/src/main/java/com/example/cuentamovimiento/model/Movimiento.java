package com.example.cuentamovimiento.model;
import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cuenta_id", nullable = false)
    private Cuenta cuenta;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimiento", nullable = false)
    private TipoMovimiento tipoMovimiento;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "saldo_despues_movimiento", nullable = false)
    private Double saldoDespuesMovimiento;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Cuenta getCuenta(){
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta){
        this.cuenta=cuenta;
    }

    public LocalDateTime getFecha(){
        return fecha;
    }

    public void setFecha(LocalDateTime fecha){
        this.fecha=fecha;
    }

    public TipoMovimiento getTipoMovimiento(){
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento){
        this.tipoMovimiento=tipoMovimiento;
    }

    public Double getValor(){
        return valor;
    }

    public void setValor(Double valor){
        this.valor=valor;
    }

    public double getSaldoDespuesMovimiento(){
        return saldoDespuesMovimiento;
    }

    public void setSaldoDespuesMovimiento(Double saldoDespuesMovimiento){
        this.saldoDespuesMovimiento=saldoDespuesMovimiento;
    }



    public enum TipoMovimiento {
        DEPOSITO, RETIRO
    }
}
