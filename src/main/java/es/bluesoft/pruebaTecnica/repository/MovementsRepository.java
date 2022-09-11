package es.bluesoft.pruebaTecnica.repository;

import es.bluesoft.pruebaTecnica.models.Accounts;
import es.bluesoft.pruebaTecnica.models.Movements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementsRepository extends JpaRepository<Movements,Long> {

    public List<Movements> getMovementsByAccount(Accounts accounts);
}
