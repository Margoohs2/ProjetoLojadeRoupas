package br.edu.unichristus.controller;

import br.edu.unichristus.data.model.Product;
import br.edu.unichristus.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/sales")
    public ResponseEntity<Map<Product, Integer>> salesReport() {
        Map<Product, Integer> report = reportService.generateProductReport();
        return ResponseEntity.ok(report);
    }
}
