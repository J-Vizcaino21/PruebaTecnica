package es.bluesoft.pruebaTecnica.service;

import es.bluesoft.pruebaTecnica.dto.AccountDTO;
import es.bluesoft.pruebaTecnica.models.Accounts;
import es.bluesoft.pruebaTecnica.models.Movements;
import es.bluesoft.pruebaTecnica.models.Users;
import es.bluesoft.pruebaTecnica.repository.AccountRepository;
import es.bluesoft.pruebaTecnica.repository.MovementsRepository;
import es.bluesoft.pruebaTecnica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MovementsRepository movementsRepository;

    public AccountDTO getAccount(Long id) {
        AccountDTO dto = new AccountDTO();
        Accounts accounts = new Accounts();
        accounts = accountRepository.getAccountsById(id);
        List<Movements> list = movementsRepository.getMovementsByAccount(accounts);
        dto.setCity(accounts.getCity().getCity());
        dto.setId(accounts.getId());
        dto.setSaldo(accounts.getSaldo());
        dto.setUser(accounts.getUser());
        dto.setCountry(accounts.getCountry().getCountry());
        dto.setCreatedAt(accounts.getCreatedAt());
        dto.setUpdatedAt(accounts.getUpdatedAt());
        dto.setMovementsList(list);
        return dto;
    }
}
