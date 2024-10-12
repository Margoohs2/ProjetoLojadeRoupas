package br.edu.unichristus.data.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="tb_client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false,length = 255)
    private String password;
}
