package dan.ms.tp.msusuarios.rest.services;

import java.util.List;
import java.util.Optional;

import dan.ms.tp.msusuarios.modelo.Usuario;

public interface UsuarioService {
   
    //Optional<Usuario> findOneByuserName(String userName);

    Usuario createUsuario(Usuario usuario);
    
    void deleteUsuario(Integer id);

    Usuario modifyUsuario(Usuario usuario);

    Optional<Usuario> getUsuarioById(Integer id);

    List<Usuario> getUsuariosByCliente(Integer cliente);

    List<Usuario> getUsuariosByClienteAndTipoUsuario(Integer cliente, Integer tipoUsuario);
    

}
