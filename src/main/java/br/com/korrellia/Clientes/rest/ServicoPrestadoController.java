package br.com.korrellia.Clientes.rest;


import br.com.korrellia.Clientes.model.entity.Cliente;
import br.com.korrellia.Clientes.model.entity.ServicoPrestado;
import br.com.korrellia.Clientes.model.repository.ClienteRepository;
import br.com.korrellia.Clientes.model.repository.ServicoPrestadoRepository;
import br.com.korrellia.Clientes.rest.dto.ServicoPrestadoDTO;
import br.com.korrellia.Clientes.util.BigDecimalConverter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository repository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar (@RequestBody ServicoPrestadoDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRepository
                .findById(idCliente)
                .orElseThrow(()->
                        new ResponseStatusException(
                                HttpStatus.BAD_REQUEST, "Cliente não encontrado"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData( data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
        return repository.save(servicoPrestado);
    }
    @GetMapping
    public List<ServicoPrestado>pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false)Integer mes
    ){
        return repository.findByNomeClienteAndMes("%" + nome +"%", mes);
    }

}
