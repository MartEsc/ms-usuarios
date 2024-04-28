package dan.ms.tp.msusuarios.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dan.ms.tp.msusuarios.dao.ClienteJpaRepository;
import dan.ms.tp.msusuarios.dao.TipoUsuarioJpaRepository;
import dan.ms.tp.msusuarios.dao.UsuarioJpaRepository;
import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.modelo.TipoUsuario;
import dan.ms.tp.msusuarios.modelo.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioJpaRepository usuarioJpaRepository;
    @Autowired
    ClienteJpaRepository clienteJpaRepository;
    @Autowired
    TipoUsuarioJpaRepository tipoUsuarioJpaRepository;

    /*@Override
    public Optional<Usuario> findOneByuserName(String userName){
        return usuarioJpaRepository.findOneByuserName(userName);
    }*/
    
    @Override
    public Usuario createUsuario(Usuario usuario) {
        
        return usuarioJpaRepository.save(usuario);
        
    }
    @Override
    public void deleteUsuario(Integer id) {
    
        usuarioJpaRepository.deleteById(id);
        return;
    }
    @Override
    public Usuario modifyUsuario(Usuario usuario) {
        
        return usuarioJpaRepository.save(usuario);
    }
    @Override
    public Optional<Usuario> getUsuarioById(Integer id) {
        // TODO Auto-generated method stub
        return usuarioJpaRepository.findById(id);
    }
    @Override
    public List<Usuario> getUsuariosByCliente(Integer idCliente) {
        Optional<Cliente> cliente = clienteJpaRepository.findById(idCliente);
        return usuarioJpaRepository.findByCliente(cliente.get());
    }
    @Override
    public List<Usuario> getUsuariosByClienteAndTipoUsuario(Integer idCliente, Integer idTipoUsuario) {
        System.out.println("Tipo usuario es "+ idTipoUsuario);
        Optional<Cliente> cliente = clienteJpaRepository.findById(idCliente);
        Optional<TipoUsuario> tipoUsuario = tipoUsuarioJpaRepository.findById(idTipoUsuario);
       
        return usuarioJpaRepository.findByClienteAndTipoUsuario(cliente.get(),tipoUsuario.get());
    }
}
