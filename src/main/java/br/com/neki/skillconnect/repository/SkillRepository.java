package br.com.neki.skillconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.skillconnect.domain.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
	


}
