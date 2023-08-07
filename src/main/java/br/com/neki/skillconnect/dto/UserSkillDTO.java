package br.com.neki.skillconnect.dto;

import br.com.neki.skillconnect.domain.SkillLevel;

public class UserSkillDTO {
	
	private Long skillId;
	private SkillLevel level;

	public UserSkillDTO() {
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
    
	public SkillLevel getLevel() {
		return level;
	}

	public void setLevel(SkillLevel level) {
		this.level = level;
	}	
}
