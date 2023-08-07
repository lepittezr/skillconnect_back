package br.com.neki.skillconnect.dto;

import br.com.neki.skillconnect.domain.Skill;
import br.com.neki.skillconnect.domain.SkillLevel;
import br.com.neki.skillconnect.security.domain.User;

public class UserSkillDTO {
	
	private User user;
	private Skill skill;
	private SkillLevel level;

	public UserSkillDTO() {
	}

	public UserSkillDTO(User user, Skill skill, SkillLevel level) {
		this.user = user;
		this.skill = skill;
		this.level = level;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public SkillLevel getLevel() {
		return level;
	}

	public void setLevel(SkillLevel level) {
		this.level = level;
	}
}
