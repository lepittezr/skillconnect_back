package br.com.neki.skillconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.neki.skillconnect.security.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	UserDetails findByLogin(String login);

}
