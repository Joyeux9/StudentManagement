package com.gestionetudiants.dao;

import com.gestionetudiants.database.Connexion;
import com.gestionetudiants.models.Etudiants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GCDAO {
    public static List<Etudiants> getEtudiants() {
        List<Etudiants> etudiants = new ArrayList<>();
        String query = "SELECT e.id_etudiant, e.nom, e.prenom, e.genre, e.dateNaissance, e.note, e.niveauActuel, " +
                "f.nomfac, f.dateInscription, " +
                "d.nomdep " +
                "FROM etudiants e " +
                "JOIN departements d ON e.id_departement = d.id_departement " +
                "JOIN facultes f ON d.id_faculte = f.id_faculte " +
                "WHERE d.nomdep = 'GC'";

        try (Connection conn = Connexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Conversion de java.sql.Date à java.util.Date
                java.util.Date dateNaissance = new java.util.Date(rs.getDate("dateNaissance").getTime());
                java.util.Date dateInscription = new java.util.Date(rs.getDate("dateInscription").getTime());

                Etudiants etudiant = new Etudiants(
                        rs.getInt("id_etudiant"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("genre"),
                        dateNaissance, // Conversion ici
                        rs.getDouble("note"),
                        rs.getString("nomfac"),
                        rs.getString("nomdep"),
                        dateInscription,
                        rs.getString("niveauActuel"));
                etudiants.add(etudiant);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return etudiants;
    }
}
