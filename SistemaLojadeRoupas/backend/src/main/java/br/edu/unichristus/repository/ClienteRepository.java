package br.edu.unichristus.repository;

import br.edu.unichristus.data.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Client, Long> {
}
