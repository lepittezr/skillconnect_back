package br.com.neki.skillconnect.security.dto;

import br.com.neki.skillconnect.security.domain.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
