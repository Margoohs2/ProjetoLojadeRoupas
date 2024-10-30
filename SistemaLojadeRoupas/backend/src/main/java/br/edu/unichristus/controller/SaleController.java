package br.edu.unichristus.controller;

import br.edu.unichristus.data.model.Product;
import br.edu.unichristus.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reports")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping("/sales")
    public ResponseEntity<String> gerarRelatorio() {
        // Chama o método gerarRelatorio do serviço para obter o relatório de vendas
        String relatorio = service.generateReport();
        return ResponseEntity.ok(relatorio);
    }
}
