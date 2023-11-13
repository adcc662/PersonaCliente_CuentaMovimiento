package com.example.personacliente.service;
import com.example.personacliente.model.Cliente;
import com.example.personacliente.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

        @Autowired
        private ClienteRepository clienteRepository;

        public Cliente crearCliente(Cliente cliente){
            return clienteRepository.save(cliente);
        }

        public List<Cliente> listarClientes(){
            return clienteRepository.findAll();
        }

        public Optional<Cliente> obtenerCliente(Long id){
            return clienteRepository.findById(id);
        }

        public void eliminarCliente(Long id){
            clienteRepository.deleteById(id);
        }

        public Cliente actualizarCliente(Long id, Cliente cliente){
            return clienteRepository.findById(id)
                    .map(clienteActualizado -> {
                        clienteActualizado.setNombre(cliente.getNombre());
                        clienteActualizado.setGenero(cliente.getGenero());
                        clienteActualizado.setEdad(cliente.getEdad());
                        clienteActualizado.setIdentificacion(cliente.getIdentificacion());
                        clienteActualizado.setDireccion(cliente.getDireccion());
                        clienteActualizado.setTelefono(cliente.getTelefono());
                        clienteActualizado.setContrasena(cliente.getContrasena());
                        clienteActualizado.setEstado(cliente.getEstado());
                        return clienteRepository.save(clienteActualizado);
                    })
                    .orElseThrow(() -> new EntityNotFoundException("No se encontro el cliente con id: " + id));
        }

}
