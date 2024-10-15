package com.example.brinquedos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}
