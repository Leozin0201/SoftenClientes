package br.com.soften.softenclientes.model.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class Cliente {
    private UUID id;
    private String nome;
    private Long cpf;
    private String email;
    private String logradouro;
    private String bairro;
    private Long cep;
    private String cidade;
}