package br.edu.unichristus.service;

import br.edu.unichristus.data.dto.ProductDTO;
import br.edu.unichristus.data.dto.ProductLowDTO;
import br.edu.unichristus.data.model.Product;
import br.edu.unichristus.dozer.DozerConverter;
import br.edu.unichristus.exception.CommonsException;
import br.edu.unichristus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDTO save(ProductDTO product){
        if(product.getName().length() > 150){
            throw new CommonsException(HttpStatus.BAD_REQUEST,
                    "unichristus.service.user.badrequest",
                    "O limite de caracteres do nome do produto é 150");
        }
        //Converte ProductDTO em Product
        var entity = DozerConverter.parseObject(product, Product.class);

        //Recebe retorno do save (Product)
        var entityDTO = repository.save(entity);

        //Converte e retorna o Product em ProductDTO
        return DozerConverter.parseObject(entityDTO, ProductDTO.class);
    }

    //retorna a lista de todos os produtos por meio de ProductLowDTO
    public List<ProductLowDTO> findAll(){
        return DozerConverter.parseListObjects(
                repository.findAll(), ProductLowDTO.class);
    }

    //deleta um produto especifico por meio de seu id
    public void delete(Long id){
        repository.deleteById(id);
    }

    //encontra um produto especifico por meio de seu id (com excecao caso nao exista)
    public ProductDTO findById(Long id){
        var entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "unichristus.service.product.notfound",
                    "O produto com o ID informado não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), ProductDTO.class);
    }

}
