package es.bluesoft.pruebaTecnica.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import es.bluesoft.pruebaTecnica.dto.User;
import es.bluesoft.pruebaTecnica.models.Users;
import es.bluesoft.pruebaTecnica.service.RolService;
import es.bluesoft.pruebaTecnica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {
	private final UserService service;
	private final RolService rolservice;

	@Autowired
	public UserController(UserService service, RolService rolservice) {
		this.service = service;
		this.rolservice=rolservice;
	}

	@PostMapping("user")
	public User login(@RequestParam("email") String email, @RequestParam("password") String pwd) {
		User user = new User();
		Users users = service.getUsr(email, pwd);
		if (users != null) {
			List<String> roles = rolservice.getRoles(users.getId());
			String token = getJWTToken(email,roles);
			user.setUser(users.getName() +" "+users.getLastname());
			user.setId(users.getId());
			user.setEmail(users.getEmail());
			user.setUbication(users.getCity().getCity()+ " - "+users.getCountry().getCountry());
			user.setToken(token);
			return user;
		} else {
			return null;
		}
		
	}

	private String getJWTToken(String username, List<String> roles) {
		String secretKey = "BlueSOft2022#TestSecurity";
		String listString = String.join(", ", roles);
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(listString);
		
		String token = Jwts
				.builder()
				.setId("BlueSoftJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
