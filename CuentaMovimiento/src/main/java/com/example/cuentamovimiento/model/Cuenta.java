package com.example.cuentamovimiento.model;
import jakarta.persistence.*;

@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_cuenta", nullable = false, unique = true)
    private String numeroCuenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cuenta", nullable = false)
    private TipoCuenta tipoCuenta;

    @Column(name = "saldo_inicial", nullable = false)
    private Double saldoInicial;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getNumeroCuenta(){
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta){
        this.numeroCuenta=numeroCuenta;
    }

    public TipoCuenta getTipoCuenta(){
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta){
        this.tipoCuenta=tipoCuenta;
    }

    public Double getSaldoInicial(){
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial){
        this.saldoInicial=saldoInicial;
    }

    public boolean getEstado(){
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado=estado;
    }


    public enum TipoCuenta {
        AHORROS, CORRIENTE
    }



}
