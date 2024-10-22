package br.edu.unichristus.service;

import br.edu.unichristus.data.dto.ClientDTO;
import br.edu.unichristus.data.dto.ClientLowDTO;
import br.edu.unichristus.data.model.Client;
import br.edu.unichristus.dozer.DozerConverter;
import br.edu.unichristus.exception.CommonsException;
import br.edu.unichristus.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientDTO save(ClientDTO client){
        if(client.getName().length() > 150){
            throw new CommonsException(HttpStatus.BAD_REQUEST,
                    "unichristus.service.client.badrequest",
                    "O limite de caracteres do nome do cliente é 150");
        }

        var entity = DozerConverter.parseObject(client, Client.class);

        var entityDTO = repository.save(entity);

        return DozerConverter.parseObject(entityDTO, ClientDTO.class);
    }

    public List<ClientLowDTO> findAll(){
        return DozerConverter.parseListObjects(
                repository.findAll(), ClientLowDTO.class);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public ClientDTO findById(Long id){
        var entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "unichristus.service.client.notfound",
                    "O cliente com o ID informado não foi encontrado");
        }
        return DozerConverter.parseObject(entity.get(), ClientDTO.class);
    }

}