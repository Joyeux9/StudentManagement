package com.gestionetudiants.dao;

import com.gestionetudiants.database.Connexion;
import com.gestionetudiants.models.Etudiants;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HistoriqueDAO {
    private Connection con;

    public HistoriqueDAO(Connection con) {
        this.con = con;
    }

    // ✅ Méthode complète : avancer un étudiant (maj + historique)
    public void avancerEtudiant(int id_etudiant) throws SQLException {
        // Étape 1 : récupérer l'étudiant
        String selectSql = "SELECT niveauActuel FROM etudiants WHERE id_etudiant = ?";
        PreparedStatement ps1 = con.prepareStatement(selectSql);
        ps1.setInt(1, id_etudiant);
        ResultSet rs = ps1.executeQuery();

        if (rs.next()) {
            String ancienNiveau = rs.getString("niveauActuel");
            String nouveauNiveau = getNiveauSuivant(ancienNiveau);

            if (!ancienNiveau.equals(nouveauNiveau)) {
                // Étape 2 : mettre à jour le niveau dans `etudiants`
                String updateSql = "UPDATE etudiants SET niveauActuel = ? WHERE id_etudiant = ?";
                PreparedStatement ps2 = con.prepareStatement(updateSql);
                ps2.setString(1, nouveauNiveau);
                ps2.setInt(2, id_etudiant);
                ps2.executeUpdate();

                // Étape 3 : enregistrer l'historique
                String insertSql = "INSERT INTO historiques (id_etudiant, ancien_niveau, nouveau_niveau, date_changement) VALUES (?, ?, ?, NOW())";
                PreparedStatement ps3 = con.prepareStatement(insertSql);
                ps3.setInt(1, id_etudiant);
                ps3.setString(2, ancienNiveau);
                ps3.setString(3, nouveauNiveau);
                ps3.executeUpdate();
            }
        }
    }

    // ✅ Logique métier pour déterminer le niveau suivant
    private String getNiveauSuivant(String niveau) {
        switch (niveau) {
            case "BAC1":
                return "BAC2";
            case "BAC2":
                return "BAC3";
            case "BAC3":
                return "BAC4";
            case "BAC4":
                return "BAC4"; // ou "Diplômé"
            default:
                return niveau;
        }
    }
}
