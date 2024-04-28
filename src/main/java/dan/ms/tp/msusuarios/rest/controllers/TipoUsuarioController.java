package dan.ms.tp.msusuarios.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dan.ms.tp.msusuarios.dao.TipoUsuarioJpaRepository;
import dan.ms.tp.msusuarios.modelo.TipoUsuario;

@RestController
@RequestMapping("api/tipo-usuario")
public class TipoUsuarioController {
 
    @Autowired
    TipoUsuarioJpaRepository tipoUsrRepo;


    @GetMapping
    public ResponseEntity<List<TipoUsuario>> getAllTipoUsuario(){
        return ResponseEntity.ok().body(tipoUsrRepo.findAll());
    }

    
    @GetMapping("/search")    
    public ResponseEntity<Optional<TipoUsuario>> getTipoUsuario(@RequestParam(name = "tipo", required = true) String tipo) {
        Optional<TipoUsuario> tipoUsuario;
        tipoUsuario = tipoUsrRepo.findOneByTipo(tipo);
        return new ResponseEntity<>(tipoUsuario, HttpStatus.OK);
    }
}
