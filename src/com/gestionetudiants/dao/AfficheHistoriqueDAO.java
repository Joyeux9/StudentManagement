package com.gestionetudiants.dao;

import com.gestionetudiants.models.Historique;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AfficheHistoriqueDAO {
    private Connection con;

    public AfficheHistoriqueDAO(Connection con) {
        this.con = con;
    }

    public List<Historique> getAllHistorique() {
        List<Historique> liste = new ArrayList<>();
        String sql = "SELECT h.id_etudiant, e.nom, e.prenom, h.ancien_niveau, h.nouveau_niveau, h.date_changement " +
                "FROM historiques h " +
                "JOIN etudiants e ON h.id_etudiant = e.id_etudiant " +
                "ORDER BY h.date_changement DESC";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Historique historique = new Historique();
                historique.setId_etudiant(rs.getInt("id_etudiant"));
                historique.setNom(rs.getString("nom"));
                historique.setPrenom(rs.getString("prenom"));
                historique.setAncien_niveau(rs.getString("ancien_niveau"));
                historique.setNouveau_niveau(rs.getString("nouveau_niveau"));
                historique.setDate_changement(rs.getTimestamp("date_changement"));
                liste.add(historique);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return liste;
    }
}
