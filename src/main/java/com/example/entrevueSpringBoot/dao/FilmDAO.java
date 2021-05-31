/**
 * @author Dominic Tardif
 */
package com.example.entrevueSpringBoot.dao;

import com.example.entrevueSpringBoot.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface related to the Film class. Extends JpaRepository for access to CRUD operations.
 */
public interface FilmDAO extends JpaRepository<Film, Long> {
}
