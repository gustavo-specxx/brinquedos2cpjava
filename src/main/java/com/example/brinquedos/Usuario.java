package com.example.brinquedos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Mantém a estratégia para auto-incremento
    @Column(name = "id_usuario") // Nome da coluna correspondente na tabela
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String senha; // Altere para "senha" para corresponder ao nome da coluna

    @Column(nullable = false, unique = true)
    private String email;

    // Construtores
    public Usuario() {
    }

    public Usuario(String username, String senha, String email) {
        this.username = username;
        this.senha = senha; // Use "senha"
        this.email = email;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha; // Use "senha"
    }

    public void setSenha(String senha) {
        this.senha = senha; // Use "senha"
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {

    }
}
