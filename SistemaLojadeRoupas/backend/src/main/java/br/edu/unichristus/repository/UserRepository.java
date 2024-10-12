package br.edu.unichristus.repository;

import br.edu.unichristus.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Product, Long> {



}
