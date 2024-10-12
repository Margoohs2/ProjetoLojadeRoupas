package br.edu.unichristus.repository;

import br.edu.unichristus.data.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
