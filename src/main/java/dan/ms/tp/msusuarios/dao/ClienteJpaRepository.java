package dan.ms.tp.msusuarios.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import dan.ms.tp.msusuarios.modelo.Cliente;

@Repository
public interface ClienteJpaRepository extends JpaRepository<Cliente,Integer> {
    @NonNull
    Optional<Cliente> findById(Integer id);
    @NonNull
    Optional<Cliente> findOneByCuit(String cuit);
}
