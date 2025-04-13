package com.gestionetudiants.models;

public class Faculte {
    private int id_faculte;
    private String nomFac;

    public Faculte() {
    }

    public Faculte(int id_faculte, String nomFac, String niveau) {
        this.id_faculte = id_faculte;
        this.nomFac = nomFac;

    }

    public int getId_faculte() {
        return id_faculte;
    }

    public void setId_faculte(int id_faculte) {
        this.id_faculte = id_faculte;
    }

    public String getNomFac() {
        return nomFac;
    }

    public void setNomFac(String nomFac) {
        this.nomFac = nomFac;
    }
}
