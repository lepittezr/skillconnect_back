package br.com.neki.skillconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.skillconnect.domain.Skill;
import br.com.neki.skillconnect.domain.UserSkill;
import br.com.neki.skillconnect.dto.UserSkillDTO;
import br.com.neki.skillconnect.repository.SkillRepository;
import br.com.neki.skillconnect.repository.UserSkillProjection;
import br.com.neki.skillconnect.repository.UserSkillRepository;
import br.com.neki.skillconnect.security.domain.User;
import br.com.neki.skillconnect.security.service.AuthService;
import jakarta.persistence.EntityNotFoundException;



@Service
public class UserSkillService {

	private final UserSkillRepository userSkillRepository;
	private final SkillRepository skillRepository;
    private final AuthService authService;

	@Autowired
	public UserSkillService(UserSkillRepository userSkillRepository, SkillRepository skillRepository, AuthService authService) {
		this.userSkillRepository = userSkillRepository;
		this.skillRepository = skillRepository;
		this.authService = authService;
	}
	
	 public void associateSkill(UserSkillDTO userSkillDTO) {
	        User currentUser = authService.getCurrentUser();
	        if (currentUser == null) {
	            throw new RuntimeException("Usuário não logado.");
	        }

	        Skill skill = skillRepository.findById(userSkillDTO.getSkillId())
	                .orElseThrow(() -> new EntityNotFoundException("Habilidade inválida"));

	        UserSkill existingAssociation = userSkillRepository.findByUserAndSkill(currentUser, skill);
	        if (existingAssociation != null) {
	            existingAssociation.setLevel(userSkillDTO.getLevel());
	            userSkillRepository.save(existingAssociation);
	        } else {
	            UserSkill userSkill = new UserSkill();
	            userSkill.setUser(currentUser);
	            userSkill.setSkill(skill);
	            userSkill.setLevel(userSkillDTO.getLevel());
	            userSkillRepository.save(userSkill);
	        }
	    }
	
	public void updateSkill(Long userSkillId, UserSkillDTO userSkillDTO) {
	    Optional<UserSkill> optionalUserSkill = userSkillRepository.findById(userSkillId);
	    if (optionalUserSkill.isPresent()) {
	        UserSkill userSkill = optionalUserSkill.get();
	        
	        userSkill.setLevel(userSkillDTO.getLevel());

	        userSkillRepository.save(userSkill);
	    } else {
	        throw new EntityNotFoundException("UserSkill with ID " + userSkillId + " not found.");
	    }
	}

	
	public void deleteSkill(Long userSkillId) {
		userSkillRepository.deleteById(userSkillId);
	}
	
    public List<UserSkillProjection> listSkillsUser(Long userId) {
        return userSkillRepository.findByUserId(userId);
    }
}
