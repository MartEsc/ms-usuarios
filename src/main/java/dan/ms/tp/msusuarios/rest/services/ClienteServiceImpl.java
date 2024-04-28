package dan.ms.tp.msusuarios.rest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dan.ms.tp.msusuarios.dao.ClienteJpaRepository;
import dan.ms.tp.msusuarios.modelo.Cliente;
import io.micrometer.common.lang.NonNull;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteJpaRepository clienteJpaRepository;

    /*@Override
    public Optional<Cliente> findOneByCuitCliente(String cuit) {
        return clienteJpaRepository.findOneByCuitCliente(cuit);
    }*/
    
    @Override
    @NonNull
    public Optional<Cliente> getClienteById(Integer id) {
        return clienteJpaRepository.findById(id);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteJpaRepository.save(cliente);
    }

    @Override
    public Object modifyCliente(Cliente cliente) {
        return clienteJpaRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Integer id) {
        clienteJpaRepository.deleteById(id);
        return;
    }

    @Override
    public Optional<Cliente> findOneByCuit(String cuit) {
        // TODO Auto-generated method stub
        return clienteJpaRepository.findOneByCuit(cuit);
    }
    
}
