package br.com.neki.skillconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.skillconnect.domain.Skill;
import br.com.neki.skillconnect.domain.UserSkill;
import br.com.neki.skillconnect.security.domain.User;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long> {
    List<UserSkillProjection> findByUserId(Long userId);

	UserSkill findByUserAndSkill(User currentUser, Skill skill);
}

