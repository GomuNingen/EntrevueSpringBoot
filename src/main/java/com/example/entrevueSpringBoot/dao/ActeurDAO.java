package com.example.entrevueSpringBoot.dao;

import com.example.entrevueSpringBoot.model.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeurDAO extends JpaRepository<Acteur, Long> {
}
