package br.com.neki.skillconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.skillconnect.domain.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long> {
    List<UserSkillProjection> findByUserId(Long userId);
}

