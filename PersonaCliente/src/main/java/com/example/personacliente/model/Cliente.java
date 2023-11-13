package com.example.personacliente.model;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Cliente extends Persona {
    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    public Cliente() {
    }

    public String getContrasena(){
        return contrasena;
    }

    public void setContrasena(String contrasena){
        this.contrasena=contrasena;
    }

    public Boolean getEstado(){
        return estado;
    }

    public void setEstado(Boolean estado){
        this.estado= Boolean.valueOf(estado);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return getContrasena().equals(cliente.getContrasena()) && getEstado().equals(cliente.getEstado());

    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), getContrasena(), getEstado());
    }

    @Override
    public String toString(){
        return "Cliente{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", edad=" + getEdad() +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", contrasena='" + getContrasena() + '\'' +
                ", estado='" + getEstado() + '\'' +
                '}';
    }



}
