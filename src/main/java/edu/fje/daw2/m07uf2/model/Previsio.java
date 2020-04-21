package edu.fje.daw2.m07uf2.model;


import org.springframework.data.annotation.Id;

/**
 * Classe entitat que representa un Previsio.
 * Es tracta d'una classe del model que es farà persistent
 * @author sergi.grau@fje.edu
 * @version  1.0 4.4.2020
 */
public class Previsio {
    @Id
    public String id;

    public String nom;
    public String cognom;
    public int volumCompres;

    public Previsio() {}

    public Previsio(String nom, String cognom, int volumCompres) {
        this.nom = nom;
        this.cognom = cognom;
        this.volumCompres=volumCompres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getVolumCompres() {
        return volumCompres;
    }

    public void setVolumCompres(int volumCompres) {
        this.volumCompres = volumCompres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Previsio)) return false;

        Previsio Previsio = (Previsio) o;

        return id.equals(Previsio.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Previsio{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", volumCompres=" + volumCompres +
                '}';
    }
}