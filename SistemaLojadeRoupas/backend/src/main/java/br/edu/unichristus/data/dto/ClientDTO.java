package br.edu.unichristus.data.dto;
import lombok.Data;
@Data
public class ClientDTO {
    private Long id;
    private String email;
    private String name;
    private String phone;
    private String password;
}
