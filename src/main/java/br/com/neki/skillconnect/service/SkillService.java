package br.com.neki.skillconnect.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.skillconnect.domain.Skill;
import br.com.neki.skillconnect.dto.SkillDTO;
import br.com.neki.skillconnect.repository.SkillRepository;


@Service
public class SkillService {
	
	
	@Autowired 
	SkillRepository skillRepository;
	
	public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public void addSkill(SkillDTO skillDTO) {
        Skill newSkill = new Skill();
        newSkill.setName(skillDTO.getName());
        newSkill.setDescription(skillDTO.getDescription());

        skillRepository.save(newSkill);
    }

	
	public List<SkillDTO> findAll() {
	    List<Skill> skills = skillRepository.findAll();

	    List<SkillDTO> skillDTOs = new ArrayList<>();
	    for (Skill skill : skills) {
	        SkillDTO skillDTO = new SkillDTO();
	        skillDTO.setId(skill.getId());
	        skillDTO.setName(skill.getName());
	        skillDTO.setDescription(skill.getDescription());
	        skillDTOs.add(skillDTO);
	    }

	    return skillDTOs;
	}


}
	
