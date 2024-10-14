package com.example.brinquedos;

import jakarta.persistence.*;

@Entity
@Table(name = "TDS_Sec_MVC_TB_Brinquedos")
public class Brinquedo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;

    // Getters e Setters
}
