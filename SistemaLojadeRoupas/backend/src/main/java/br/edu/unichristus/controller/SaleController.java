package br.edu.unichristus.controller;

import br.edu.unichristus.data.dto.ProductDTO;
import br.edu.unichristus.data.dto.SaleDTO;
import br.edu.unichristus.data.model.Sale;
import br.edu.unichristus.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @PostMapping
    public SaleDTO create(@RequestBody SaleDTO sale){
        return service.save(sale);
    }

    @PutMapping
    public SaleDTO update(@RequestBody SaleDTO sale){
        return service.save(sale);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public SaleDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/report")
    public ResponseEntity<String> gerarRelatorio() {
        // Chama o método gerarRelatorio do serviço para obter o relatório de vendas
        String relatorio = service.generateReport();
        return ResponseEntity.ok(relatorio);
    }
}
