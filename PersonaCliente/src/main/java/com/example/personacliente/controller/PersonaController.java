package com.example.personacliente.controller;
import com.example.personacliente.model.Persona;
import com.example.personacliente.service.PersonaService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona){
        Persona nuevaPersona = personaService.crearPersona(persona);
        return ResponseEntity.ok(nuevaPersona);
    }

    @GetMapping
    public ResponseEntity<List<Persona>> listarPersonas(){
        return ResponseEntity.ok(personaService.listarPersonas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerPersona(@PathVariable Long id){
        return personaService.obtenerPersona(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona persona){
        return ResponseEntity.ok(personaService.actualizarPersona(id, persona));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id){
        personaService.eliminarPersona(id);
        return ResponseEntity.ok().build();
    }

}
