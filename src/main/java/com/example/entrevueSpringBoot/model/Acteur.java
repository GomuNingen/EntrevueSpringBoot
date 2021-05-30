package com.example.entrevueSpringBoot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    public Acteur() {
    }

    public Acteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acteur acteur = (Acteur) o;
        return id == acteur.id && nom.equals(acteur.nom) && prenom.equals(acteur.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom);
    }
}
