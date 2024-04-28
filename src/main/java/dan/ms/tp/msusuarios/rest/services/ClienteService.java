package dan.ms.tp.msusuarios.rest.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dan.ms.tp.msusuarios.modelo.Cliente;


public interface ClienteService {

    public Optional<Cliente> findOneByCuit(String cuit);

    public Optional<Cliente> getClienteById(Integer id);

    public Cliente createCliente(Cliente cliente);

    public Object modifyCliente(Cliente cliente);

    public void deleteCliente(Integer id);
    
}
