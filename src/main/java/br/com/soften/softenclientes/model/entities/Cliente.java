package br.com.soften.softenclientes.model.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Cliente {
    public Cliente() {
        this.id = UUID.randomUUID();
    }
    private UUID id;
    private String nome;
    private Long cpf;
    private String email;
    private String logradouro;
    private String bairro;
    private Long cep;
    private String cidade;

    public Cliente(UUID id, String nome, Long cpf, String email, String logradouro, String bairro, Long cep, String cidade){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    public void setId(UUID id){
    }
}