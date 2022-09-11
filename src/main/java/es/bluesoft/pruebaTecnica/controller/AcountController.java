package es.bluesoft.pruebaTecnica.controller;

import es.bluesoft.pruebaTecnica.dto.AccountDTO;
import es.bluesoft.pruebaTecnica.models.Accounts;
import es.bluesoft.pruebaTecnica.service.AccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcountController {

    private final AccountService service;

    public AcountController(AccountService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_CLIENT')")
    @PostMapping("/balance")
    public AccountDTO getSaldoCuenta(@RequestParam("idAccount") Long idAccount){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO = service.getAccount(idAccount);
        return  accountDTO;
    }
}
