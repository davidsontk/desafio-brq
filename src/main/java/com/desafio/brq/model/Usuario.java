package com.desafio.brq.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 150)
    private String nome;

    @Column(length = 400)
    private String sobrenome;

    @NotNull
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @NotNull
    @Column(length = 13)
    private String cpf;

    @Column(length = 400)
    private String endereco;

    @Column(length = 9)
    private String cep;

    @Column(length = 50)
    private String telefone;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Column(name = "ultima_alteracao")
    private Date ultimaAlteracao;
}
