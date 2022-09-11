package es.bluesoft.pruebaTecnica.service;

import es.bluesoft.pruebaTecnica.models.User_roles;
import es.bluesoft.pruebaTecnica.repository.UserRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    private UserRolRepository userRolRepository;

    public User_roles setUsr(User_roles user) {
        return userRolRepository.save(user);
    }
}
