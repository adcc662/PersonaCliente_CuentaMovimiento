package com.example.personacliente.controller;
import com.example.personacliente.model.Cliente;
import com.example.personacliente.service.ClienteService;
import com.example.personacliente.kafka.service.KafkaProducerService;
import com.example.personacliente.util.JsonConverter;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    private final ClienteService clienteService;
    private final KafkaProducerService kafkaProducerService;
    private final JsonConverter jsonConverter;

    @Autowired
    public ClienteController(ClienteService clienteService,
                             KafkaProducerService kafkaProducerService,
                             JsonConverter jsonConverter){
        this.clienteService = clienteService;
        this.kafkaProducerService = kafkaProducerService;
        this.jsonConverter = jsonConverter;
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.crearCliente(cliente);
        String clienteJson = jsonConverter.convertToJson(nuevoCliente);
        kafkaProducerService.sendMessage("cliente", clienteJson);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }


        @GetMapping
        public ResponseEntity<List<Cliente>> listarClientes(){
            return ResponseEntity.ok(clienteService.listarClientes());
        }


        @GetMapping("/{id}")
        public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id){
            return clienteService.obtenerCliente(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());

        }


        @PutMapping("/{id}")
        public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente){
            return ResponseEntity.ok(clienteService.actualizarCliente(id, cliente));
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminarCliente(@PathVariable Long id){
            clienteService.eliminarCliente(id);
            return ResponseEntity.ok().build();
        }



}
