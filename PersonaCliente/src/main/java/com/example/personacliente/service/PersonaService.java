package com.example.personacliente.service;
import com.example.personacliente.model.Persona;
import com.example.personacliente.repository.PersonaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona crearPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public List<Persona> listarPersonas(){
        return personaRepository.findAll();
    }

    public Optional<Persona> obtenerPersona(Long id){
        return personaRepository.findById(id);
    }

    public void eliminarPersona(Long id){
        personaRepository.deleteById(id);
    }

    public Persona actualizarPersona(Long id, Persona persona){
        return personaRepository.findById(id)
                .map(personaActualizada -> {
                    personaActualizada.setNombre(persona.getNombre());
                    personaActualizada.setGenero(persona.getGenero());
                    personaActualizada.setEdad(persona.getEdad());
                    personaActualizada.setIdentificacion(persona.getIdentificacion());
                    personaActualizada.setDireccion(persona.getDireccion());
                    personaActualizada.setTelefono(persona.getTelefono());
                    return personaRepository.save(personaActualizada);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la persona con id: " + id));
    }
}
