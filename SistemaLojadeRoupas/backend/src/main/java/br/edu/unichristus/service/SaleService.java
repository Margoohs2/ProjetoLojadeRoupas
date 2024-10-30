package br.edu.unichristus.service;

import br.edu.unichristus.data.dto.SaleDTO;
import br.edu.unichristus.data.model.Sale;
import br.edu.unichristus.dozer.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private br.edu.unichristus.repository.SaleRepository repository;

    public SaleDTO save(SaleDTO sale){
        var entity = DozerConverter.parseObject(sale, Sale.class);

        var entityDTO = repository.save(entity);

        return DozerConverter.parseObject(entityDTO, SaleDTO.class);
    }

    public List<SaleDTO> findAll(){
        return DozerConverter.parseListObjects(
                repository.findAll(), SaleDTO.class);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public SaleDTO findById(Long id){
        var entity = repository.findById(id);

        return DozerConverter.parseObject(entity.get(), SaleDTO.class);
    }

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
//teste2
