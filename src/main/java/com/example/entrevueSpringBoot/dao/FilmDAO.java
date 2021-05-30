package com.example.entrevueSpringBoot.dao;

import com.example.entrevueSpringBoot.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmDAO extends JpaRepository<Film, Long> {
}
