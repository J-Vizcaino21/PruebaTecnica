package es.bluesoft.pruebaTecnica.service;

import es.bluesoft.pruebaTecnica.models.Users;
import es.bluesoft.pruebaTecnica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Users getUsr(String email, String password) {
        return usuarioRepository.findByEmailAndPassword(email,password);
    }

    public Users setUsr(Users usuarios) {
        return usuarioRepository.save(usuarios);
    }


    public List<Users> findAll() {
        return usuarioRepository.findAll();
    }


}
