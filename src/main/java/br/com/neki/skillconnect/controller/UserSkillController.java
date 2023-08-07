package br.com.neki.skillconnect.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.skillconnect.dto.UserSkillDTO;
import br.com.neki.skillconnect.repository.UserSkillProjection;
import br.com.neki.skillconnect.service.UserSkillService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/userSkills")
public class UserSkillController {
	
	private final UserSkillService userSkillService;
	
	public UserSkillController(UserSkillService userSkillService) {
		this.userSkillService = userSkillService;
	}
	
	@PostMapping("/associateSkill")
	@Operation(summary = "Associa uma skill ao usuário", description = "Associar Skill")
	public ResponseEntity<String> associateSkill(@RequestBody @Valid UserSkillDTO userSkillDTO) {
		userSkillService.associateSkill(userSkillDTO);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/updateSkill/{userSkillId}")
	@Operation(summary = "Altera o nível da skill", description = "Update Skill")
	public ResponseEntity<String> updateSkill(@PathVariable Long userSkillId, @RequestBody @Valid UserSkillDTO userSkillDTO) {
	    userSkillService.updateSkill(userSkillId, userSkillDTO);
	    return ResponseEntity.ok().build();
	}

	
	@DeleteMapping("deleteSkill/{userSkillId}")
	@Operation(summary = "Deleta skill do usuário", description = "Deletar Skill")
	public ResponseEntity<String> deleteSkill(@PathVariable Long userSkillId) {
		userSkillService.deleteSkill(userSkillId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/listSkillsUser/{userId}")
	@Operation(summary = "Lista todas as skills do usuário", description = "Listagem de UserSkills")
	public ResponseEntity<List<UserSkillProjection>> listSkillsUser(@PathVariable Long userId) {
	    List<UserSkillProjection> userSkills = userSkillService.listSkillsUser(userId);
	    return ResponseEntity.ok(userSkills);
	}
}
