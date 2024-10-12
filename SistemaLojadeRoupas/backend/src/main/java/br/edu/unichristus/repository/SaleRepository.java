package br.edu.unichristus.repository;

import br.edu.unichristus.data.model.ProductReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<ProductReport, Long> {
}
