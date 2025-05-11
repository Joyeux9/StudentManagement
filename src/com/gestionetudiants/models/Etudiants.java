package com.gestionetudiants.models;

import java.util.Date;

public class Etudiants {
    private int id_etudiant;
    private String nom;
    private String prenom;
    private String genre;
    private Date dateNaissance;
    private double note;
    private String nomfac;
    private String nomdep;
    private Date dateInscription;
    private String niveauActuel;

    public Etudiants() {
    }

    public Etudiants(int id_etudiant, String nom, String prenom, String genre, Date dateNaissance, double note,
            String nomfac, String nomdep, Date dateInscription, String niveauActuel) {
        this.id_etudiant = id_etudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.note = note;
        this.nomfac = nomfac;
        this.nomdep = nomdep;
        this.dateInscription = dateInscription;
        this.niveauActuel = niveauActuel;
    }

    // Getters et Setters
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

    public String getNomfac() {
        return nomfac;
    }

    public void setNomfac(String nomfac) {
        this.nomfac = nomfac;
    }

    public String getNomdep() {
        return nomdep;
    }

    public void setNomdep(String nomdep) {
        this.nomdep = nomdep;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {

    }

    public String getNiveauActuel() {
        return niveauActuel;
    }

    public void setNiveauActuel(String niveauActuel) {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id_etudiant=" + id_etudiant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", genre='" + genre + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", note=" + note +
                ", nomfac='" + nomfac + '\'' +
                ", nomdep='" + nomdep + '\'' +
                ", dateInscription='" + dateInscription + '\'' +
                ", niveauActuel='" + niveauActuel + '\'' +
                '}';
    }
}
