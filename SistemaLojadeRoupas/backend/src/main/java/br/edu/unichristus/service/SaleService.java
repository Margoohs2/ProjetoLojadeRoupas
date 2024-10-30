package br.edu.unichristus.service;

import br.edu.unichristus.data.dto.SaleDTO;
import br.edu.unichristus.data.model.Product;
import br.edu.unichristus.data.model.Sale;
import br.edu.unichristus.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private br.edu.unichristus.repository.SaleRepository repository;

    public String generateReport() {
        // Buscar todas as vendas salvas no banco de dados
        List<Sale> vendas = repository.findAll();

        // Calcular o total de vendas
        Double totalVendas = vendas.stream()
                .map(v -> v.getTotalvalue() * v.getQuantity())
                .reduce(0.0, Double::sum);

        // Montar o relatório
        return "Relatório de Vendas:\n" +
                "Total de Vendas: " + totalVendas + "\n" +
                "Vendas Realizadas: " + vendas.size();
    }

}

//teste
