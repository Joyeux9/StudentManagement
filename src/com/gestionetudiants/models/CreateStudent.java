package com.gestionetudiants.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateStudent {
    private String nom;
    private String prenom;
    private String genre;
    private String dateNaissance;
    private double note;
    private String faculte;
    private String departement;

    // Constructeur
    public CreateStudent(String nom, String prenom, String genre, String dateNaissance, double note,
            String faculte, String departement) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.note = note;
        this.faculte = faculte;
        this.departement = departement;
    }

    // Méthode pour enregistrer l'étudiant avec une transaction
    public void enregistrerEtudiant(Connection conn) throws SQLException {
        // Commencer une transaction
        conn.setAutoCommit(false); // Désactive l'auto-commit pour contrôler la transaction

        try {
            // 1. Insérer dans la table facultes
            String sqlFaculte = "INSERT INTO facultes (nomfac) VALUES (?)";
            try (PreparedStatement stmtFaculte = conn.prepareStatement(sqlFaculte,
                    PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmtFaculte.setString(1, faculte);
                stmtFaculte.executeUpdate();

                // Récupérer l'ID de la faculté insérée
                var rsFaculte = stmtFaculte.getGeneratedKeys();
                int faculteId = 0;
                if (rsFaculte.next()) {
                    faculteId = rsFaculte.getInt(1);
                }

                // 2. Insérer dans la table departements
                String sqlDepartement = "INSERT INTO departements (nomdep, id_faculte) VALUES (?, ?)";
                try (PreparedStatement stmtDepartement = conn.prepareStatement(sqlDepartement,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {

                    stmtDepartement.setString(1, departement);
                    stmtDepartement.setInt(2, faculteId); // Utiliser l'ID de la faculté insérée
                    stmtDepartement.executeUpdate();

                    // Récupérer l'ID du département inséré
                    var rsDepartement = stmtDepartement.getGeneratedKeys();
                    int departementId = 0;
                    if (rsDepartement.next()) {
                        departementId = rsDepartement.getInt(1);
                    }

                    // 3. Insérer dans la table etudiants
                    String sqlEtudiant = "INSERT INTO etudiants (nom, prenom, genre, dateNaissance, note, id_departement, id_faculte) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement stmtEtudiant = conn.prepareStatement(sqlEtudiant)) {
                        stmtEtudiant.setString(1, nom);
                        stmtEtudiant.setString(2, prenom);
                        stmtEtudiant.setString(3, genre);
                        stmtEtudiant.setString(4, dateNaissance);
                        stmtEtudiant.setDouble(5, note);
                        stmtEtudiant.setInt(6, departementId); // Utiliser l'ID du département inséré
                        stmtEtudiant.setInt(7, faculteId);
                        stmtEtudiant.executeUpdate();
                    }

                }

            }

            // Si tout s'est bien passé, commit de la transaction
            conn.commit();

        } catch (SQLException e) {
            // En cas d'erreur, rollback la transaction
            if (conn != null) {
                conn.rollback();
            }
            throw e; // Rethrow l'exception pour que l'appelant puisse la gérer
        } finally {
            // Restaurer l'auto-commit et fermer la connexion
            if (conn != null) {
                conn.setAutoCommit(true); // Restaurer le mode par défaut
            }
        }
    }
}
