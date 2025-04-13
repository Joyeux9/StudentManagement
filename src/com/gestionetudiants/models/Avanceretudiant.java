package com.gestionetudiants.models;

import java.util.Date;

public class Avanceretudiant {
    private int id_etudiant;
    private String nom;
    private String prenom;
    private String genre;
    private Date dateNaissance;
    private double note;
    private String niveau;

    public Avanceretudiant() {
    }

    public Avanceretudiant(int id_etudiant, String nom, String prenom, String genre, Date dateNaissance, double note,
            String niveau) {
        this.id_etudiant = id_etudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.note = note;
        this.niveau = niveau;
    }

    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;

    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}
