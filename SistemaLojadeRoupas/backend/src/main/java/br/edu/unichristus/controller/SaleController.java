package br.edu.unichristus.controller;

import br.edu.unichristus.data.dto.SaleDTO;
import br.edu.unichristus.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @Operation(summary = "Cadastra os dados de uma venda",
            tags = "Sale")
    @PostMapping
    public SaleDTO create(@RequestBody SaleDTO sale){
        return service.save(sale);
    }

    @Operation(summary = "Atualiza os dados de uma venda",
            tags = "Sale")
    @PutMapping
    public SaleDTO update(@RequestBody SaleDTO sale){
        return service.save(sale);
    }

    @Operation(summary = "Deleta uma venda baseado em seu id",
            tags = "Sale")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @Operation(summary = "Recupera os dados de uma venda baseado em seu id",
            tags = "Sale")
    @GetMapping("/{id}")
    public SaleDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @Operation(summary = "Gera um relatório das vendas cadastradas",
            tags = "Sale")
    @GetMapping("/report")
    public ResponseEntity<String> gerarRelatorio() {
        // Chama o método gerarRelatorio do serviço para obter o relatório de vendas
        String relatorio = service.generateReport();
        return ResponseEntity.ok(relatorio);
    }
}
