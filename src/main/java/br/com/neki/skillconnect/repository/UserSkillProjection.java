package br.com.neki.skillconnect.repository;

import br.com.neki.skillconnect.domain.Skill;

public interface UserSkillProjection {
    Long getId();
    Skill getSkill();
    String getLevel();
}