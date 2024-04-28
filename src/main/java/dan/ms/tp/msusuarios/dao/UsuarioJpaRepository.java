package dan.ms.tp.msusuarios.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.modelo.TipoUsuario;
import dan.ms.tp.msusuarios.modelo.Usuario;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario,Integer>{
    Optional<Usuario> findOneByuserName(String userName);
    Optional<Usuario> findById(Integer id);
    List<Usuario> findByCliente(Cliente cliente);
    List<Usuario> findByClienteAndTipoUsuario(Cliente cliente, TipoUsuario tipoUsuario);
}
