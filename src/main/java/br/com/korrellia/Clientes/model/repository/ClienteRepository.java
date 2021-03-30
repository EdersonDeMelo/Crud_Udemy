package br.com.korrellia.Clientes.model.repository;


import br.com.korrellia.Clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
