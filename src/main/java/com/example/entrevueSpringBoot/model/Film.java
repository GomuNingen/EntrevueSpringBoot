package com.example.entrevueSpringBoot.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(targetEntity = Acteur.class)
    private List<Acteur> acteurs;

    public Film() {
    }

    public Film(String titre, String description, List<Acteur> acteurs) {
        this.titre = titre;
        this.description = description;
        this.acteurs = acteurs;
    }

    public long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id && titre.equals(film.titre) && description.equals(film.description) && acteurs.equals(film.acteurs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, description, acteurs);
    }
}
