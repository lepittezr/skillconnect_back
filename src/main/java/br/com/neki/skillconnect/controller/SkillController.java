package br.com.neki.skillconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.skillconnect.dto.SkillDTO;
import br.com.neki.skillconnect.repository.SkillRepository;
import br.com.neki.skillconnect.service.SkillService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/skill")
public class SkillController {
	
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

	@Autowired
	SkillRepository skillRepository;
	
	@PostMapping("/postSkill")
	public ResponseEntity<String> postSkill(@RequestBody @Valid SkillDTO skillDTO) {
	    skillService.addSkill(skillDTO);
	    return ResponseEntity.ok().build();
	}
	
    @GetMapping("/list")
    public List<SkillDTO> listar() {
        return skillService.findAll();
    }
}
