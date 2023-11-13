package com.example.personacliente.model;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "genero", nullable = false, length = 10)
    private String genero;

    @Column(name = "edad", length = 3)
    private int edad;

    @Column(name = "identificacion", nullable = false, length = 50)
    private String identificacion;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "telefono", length = 50)
    private String telefono;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero=genero;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad=edad;
    }

    public String getIdentificacion(){
        return identificacion;
    }

    public void setIdentificacion(String identificacion){
        this.identificacion=identificacion;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion=direccion;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono=telefono;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Persona)) return false;
        Persona persona=(Persona) o;
        return Objects.equals(id, persona.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Persona{"+
                "id="+id+
                ", nombre='"+nombre+'\''+
                ", genero='"+genero+'\''+
                ", edad="+edad+
                ", identificacion='"+identificacion+'\''+
                ", direccion='"+direccion+'\''+
                ", telefono='"+telefono+'\''+
                '}';
    }

}
