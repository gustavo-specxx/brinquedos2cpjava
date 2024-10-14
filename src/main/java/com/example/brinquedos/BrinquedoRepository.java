package com.example.brinquedos;

import com.example.brinquedos.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {
    // Métodos personalizados podem ser adicionados aqui
}
