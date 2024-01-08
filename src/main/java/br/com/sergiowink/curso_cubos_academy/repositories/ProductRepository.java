package br.com.sergiowink.curso_cubos_academy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sergiowink.curso_cubos_academy.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
