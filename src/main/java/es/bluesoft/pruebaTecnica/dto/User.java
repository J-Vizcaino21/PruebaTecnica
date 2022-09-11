package es.bluesoft.pruebaTecnica.dto;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String user;
    private String pwd;
    private String email;
    private String token;
    private String ubication;
}
