package es.bluesoft.pruebaTecnica.repository;

import es.bluesoft.pruebaTecnica.models.User_roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolRepository extends JpaRepository<User_roles,Long> {
}
