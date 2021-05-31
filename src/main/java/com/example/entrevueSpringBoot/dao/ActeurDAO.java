/**
 * @author Dominic Tardif
 */
package com.example.entrevueSpringBoot.dao;

import com.example.entrevueSpringBoot.models.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface related to the Acteur class (not needed for this exercise)
 */
public interface ActeurDAO extends JpaRepository<Acteur, Long> {
}
