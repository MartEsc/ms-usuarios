package dan.ms.tp.msusuarios.rest.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.rest.services.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    
    //Busqueda por cuit
    @GetMapping(value = "/cuitCliente")
    @PreAuthorize("hasRole('lectura')")
    public ResponseEntity<Optional<Cliente>> getClienteBycuitCliente(@RequestParam(name = "cuitCliente", required = true) String cuitCliente) {
        Optional<Cliente> cliente;
        cliente = clienteService.findOneByCuit(cuitCliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    //Busqueda por id
    @GetMapping(value="/idCliente")
    @PreAuthorize("hasRole('lectura')")
    public ResponseEntity<Optional<Cliente>> getClienteById(@RequestParam(value="id",required=true) Integer id) {
        Optional<Cliente> cliente;
        cliente = clienteService.getClienteById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    //Alta cliente
    @PostMapping(value="/altaCliente")
    @PreAuthorize("hasRole('escritura') or hasRole('administracion')")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        Cliente clienteNuevo = clienteService.createCliente(cliente);
        return new ResponseEntity<>(clienteNuevo, HttpStatus.CREATED);
    }
    //Modificacion cliente
    @PutMapping(value="/modificarCliente")
    @PreAuthorize("hasRole('escritura') or hasRole('administracion')")
    public ResponseEntity<Object> modifyCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok().body(clienteService.modifyCliente(cliente));
    }
    //Baja cliente
    @DeleteMapping("/bajaCliente")
    @PreAuthorize("hasRole('escritura') or hasRole('administracion')")
    public String deleteById(@RequestParam(value = "id")  Integer id) {
        clienteService.deleteCliente(id);
       return "Delete by id called";
    }
}
