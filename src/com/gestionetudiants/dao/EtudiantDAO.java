package com.gestionetudiants.dao;

import com.gestionetudiants.models.Etudiants;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EtudiantDAO {
    private Connection con;

    public EtudiantDAO(Connection con) {
        this.con = con;
    }

    public boolean updateEtudiant(Etudiants etudiant) {
        String sql = "UPDATE etudiants SET nom = ?, prenom = ?, genre = ?, dateNaissance = ?, nomfac = ?, nomdep = ? WHERE id_etudiant = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setString(3, etudiant.getGenre());
            ps.setDate(4, new java.sql.Date(etudiant.getDateNaissance().getTime()));
            ps.setString(5, etudiant.getNomfac()); // Modifier par nomfac
            ps.setString(6, etudiant.getNomdep()); // Modifier par nomdep
            ps.setInt(7, etudiant.getId_etudiant());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
