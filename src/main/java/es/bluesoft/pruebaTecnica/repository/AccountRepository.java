package es.bluesoft.pruebaTecnica.repository;

import es.bluesoft.pruebaTecnica.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,Long> {
    public Accounts getAccountsById(Long id);
}
