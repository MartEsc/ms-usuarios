package dan.ms.tp.msusuarios.rest.services;

import java.util.List;
import java.util.Optional;

import dan.ms.tp.msusuarios.modelo.TipoUsuario;
import org.springframework.stereotype.Service;

@Service
public interface TipoUsuarioService {
    List<TipoUsuario> findAll();
    Optional<TipoUsuario> findOneByTipo(String tipo);
}
