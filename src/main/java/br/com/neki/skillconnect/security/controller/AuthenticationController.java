package br.com.neki.skillconnect.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.skillconnect.repository.UserRepository;
import br.com.neki.skillconnect.security.domain.User;
import br.com.neki.skillconnect.security.dto.AuthenticationDTO;
import br.com.neki.skillconnect.security.dto.LoginResponseDTO;
import br.com.neki.skillconnect.security.dto.RegisterDTO;
import br.com.neki.skillconnect.security.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
	    try {
	        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
	        var auth = this.authenticationManager.authenticate(usernamePassword);

	        var token = tokenService.generateToken((User) auth.getPrincipal());

	        return ResponseEntity.ok(new LoginResponseDTO(token));
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro durante a autenticação: " + e.getMessage());
	    }
	}

	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		if(this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		User newUser = new User(data.login(), encryptedPassword, data.role());
		
		this.userRepository.save(newUser);
		
		return ResponseEntity.ok().build();
		
	}
}
