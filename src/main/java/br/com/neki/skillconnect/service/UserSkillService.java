package br.com.neki.skillconnect.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.neki.skillconnect.domain.UserSkill;
import br.com.neki.skillconnect.dto.UserSkillDTO;
import br.com.neki.skillconnect.repository.UserSkillProjection;
import br.com.neki.skillconnect.repository.UserSkillRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserSkillService {

	private final UserSkillRepository userSkillRepository;
	
	public UserSkillService(UserSkillRepository userSkillRepository) {
		this.userSkillRepository = userSkillRepository;
	}
	
	public void associateSkill(UserSkillDTO userSkillDTO) {
		UserSkill userSkill = new UserSkill();
		
		userSkill.setUser(userSkillDTO.getUser());
		userSkill.setSkill(userSkillDTO.getSkill());
		userSkill.setLevel(userSkillDTO.getLevel());
		
		userSkillRepository.save(userSkill);
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
