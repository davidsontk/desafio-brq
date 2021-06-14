package com.desafio.brq.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Nome é obrigatorio")
    @NotEmpty(message = "Nome é obrigatorio")
    @Column(length = 150)
    private String nome;

    @Column(length = 400)
    private String sobrenome;

    @NotNull(message = "Data de nascimento é obrigatorio")
    @Column(name = "data_nascimento")
    private Timestamp dataNascimento;

    @NotNull(message = "CPF é obrigatorio")
    @NotEmpty(message = "CPF é obrigatorio")
    @Column(length = 14)
    private String cpf;

    @NotNull(message = "Endereco é obrigatorio")
    @NotEmpty(message = "Endereco é obrigatorio")
    @Column(length = 400)
    private String endereco;

    @Column(length = 9)
    private String cep;

    @Column(length = 50)
    private String telefone;

    @NotNull
    @Column(name = "data_cadastro")
    private Timestamp dataCadastro;

    @NotNull
    @Column(name = "ultima_alteracao")
    private Timestamp ultimaAlteracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Timestamp getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(Timestamp ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }
}
