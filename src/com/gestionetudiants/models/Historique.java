package com.gestionetudiants.models;

import java.sql.Timestamp;

public class Historique {
    private int id_historique;
    private int id_etudiant;
    private String ancien_niveau;
    private String nouveau_niveau;
    private Timestamp date_changement;
    private String nom;
    private String prenom;

    // Constructeur par défaut
    public Historique() {
    }

    // Constructeur complet
    public Historique(int id_historique, int id_etudiant, String nom, String prenom, String ancien_niveau,
            String nouveau_niveau,
            Timestamp date_changement) {
        this.id_historique = id_historique;
        this.id_etudiant = id_etudiant;
        this.ancien_niveau = ancien_niveau;
        this.nouveau_niveau = nouveau_niveau;
        this.date_changement = date_changement;
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getters et Setters
    public int getId_historique() {
        return id_historique;
    }

    public void setId_historique(int id_historique) {
        this.id_historique = id_historique;
    }

    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public String getAncien_niveau() {
        return ancien_niveau;
    }

    public void setAncien_niveau(String ancien_niveau) {
        this.ancien_niveau = ancien_niveau;
    }

    public String getNouveau_niveau() {
        return nouveau_niveau;
    }

    public void setNouveau_niveau(String nouveau_niveau) {
        this.nouveau_niveau = nouveau_niveau;
    }

    public Timestamp getDate_changement() {
        return date_changement;
    }

    public void setDate_changement(Timestamp date_changement) {
        this.date_changement = date_changement;
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
}
