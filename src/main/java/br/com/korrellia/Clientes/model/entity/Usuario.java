package br.com.korrellia.Clientes.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "login")
    @NotEmpty(message = "Campo login é obrigatorio")
    private String username;

    @Column(name = "senha")
    @NotEmpty(message = "Campo senha é obrigatorio")
    private String password;
}
