package br.com.korrellia.Clientes;

import br.com.korrellia.Clientes.model.entity.Cliente;
import br.com.korrellia.Clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {
//
//	@Bean
//	public CommandLineRunner runner(@Autowired ClienteRepository repository){
//		return args -> {
//			Cliente cliente = Cliente.builder().cpf("09876543212").nome("Ederson").build();
//			repository.save(cliente);
//		};
//	}

	public static void main(String[] args) {

		SpringApplication.run(ClientesApplication.class, args);
	}

}
