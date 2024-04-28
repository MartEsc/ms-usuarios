package dan.ms.tp.msusuarios.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dan.ms.tp.msusuarios.modelo.Usuario;
import dan.ms.tp.msusuarios.rest.services.UsuarioService;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    
    /*@GetMapping(value = "/userName")   
    public ResponseEntity<Optional<Usuario>> getUsuarioByUsername(@RequestParam(name = "userName", required = true) String userName) {
        Optional<Usuario> usuario;
        usuario = usuarioService.findOneByuserName(userName);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }*/
    @GetMapping(value="/idUsuario")
    public ResponseEntity<Optional<Usuario>> getUsuarioById(@RequestParam(value="id",required=true) Integer id) {
        Optional<Usuario> usuario;
        usuario = usuarioService.getUsuarioById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/cliente")    
    public ResponseEntity<List<Usuario>> getUsuariosByCliente(@RequestParam(name = "cliente", required = true) Integer cliente){
        List<Usuario> usuarios;
        usuarios = usuarioService.getUsuariosByCliente(cliente);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/clienteAndTipo")    
    public ResponseEntity<List<Usuario>> getUsuariosByClienteAndTipoUsuario(@RequestParam(name = "cliente", required = true) Integer cliente,@RequestParam(name ="tipoUsuario", required = true) Integer tipo){
        List<Usuario> usuarios;
        usuarios = usuarioService.getUsuariosByClienteAndTipoUsuario(cliente,tipo);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping(value="/altaUsuario")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        Usuario usuarioNuevo = usuarioService.createUsuario(usuario);
        return new ResponseEntity<>(usuarioNuevo, HttpStatus.CREATED);
    }

    @PutMapping(value="/modificarUsuario")
    public ResponseEntity<Usuario> modifyUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok().body(usuarioService.modifyUsuario(usuario));
    }
/*
    @DeleteMapping(value="/bajaUsuario")
    public ResponseEntity<Void> deleteUsuario(@RequestBody Integer id){
        return ResponseEntity.ok().body(usuarioService.deleteUsuario(id));
    }*/
    @DeleteMapping("/bajaUsuario")
    public String deleteById(@RequestParam(value = "id")  Integer id) {
        usuarioService.deleteUsuario(id);
       return "Delete by id called";
    }
   
    
}
