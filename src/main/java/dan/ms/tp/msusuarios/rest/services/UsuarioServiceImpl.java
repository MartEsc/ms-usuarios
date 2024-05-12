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
    public Usuario createUsuario(Usuario usuario) throws Exception {
        validarReglasNegocio(usuario);
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

    private void validarReglasNegocio(Usuario usuario) throws Exception {
        //validacion credenciales
        if(!(usuario.getUserName()!=null)){
            throw new Exception("El campo usuario no puede estar vacío");
        }
        String password = usuario.getPassword();

        
        if (password.length() < 12) 
        {
            throw new Exception("La contraseña debe tener al menos 12 caracteres.");
        }
        
        


        //Validacion cliente
        Optional<Cliente> cliente = clienteJpaRepository.findById(usuario.getCliente().getId());
        if(!cliente.isPresent()){
            throw new Exception("No hay cliente correspondiente al usuario");
        }
        else{
            usuario.setCliente(cliente.get());
        }

        //validacion tipoUsuario
        Optional<TipoUsuario> tipoGerente = tipoUsuarioJpaRepository.findOneByTipo("GERENTE");

        if(!tipoGerente.isPresent()){
            throw new Exception("No hay cliente correspondiente al usuario");
        }
        else{
            usuario.setTipoUsuario(tipoGerente.get());
        }
        //validacion cantidadGerentes
        List<Usuario> usuariosGerentes = usuarioJpaRepository.findByClienteAndTipoUsuario(usuario.getCliente(), tipoGerente.get());
        if(usuariosGerentes.size()>1){
            throw new Exception("No puede haber mas de un gerente para el usuario "+usuario.getUserName());
        }

        

    }
}
