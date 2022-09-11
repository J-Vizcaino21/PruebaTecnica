package es.bluesoft.pruebaTecnica.dto;


import es.bluesoft.pruebaTecnica.models.City;
import es.bluesoft.pruebaTecnica.models.Country;
import es.bluesoft.pruebaTecnica.models.Movements;
import es.bluesoft.pruebaTecnica.models.Users;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AccountDTO {
    private Long id;
    private String country;
    private String city;
    private Users user;
    private Double saldo;
    private Date createdAt;
    private Date updatedAt;
    private List<Movements> movementsList;
}
