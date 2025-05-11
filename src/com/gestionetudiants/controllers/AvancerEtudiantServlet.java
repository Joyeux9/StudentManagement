package com.gestionetudiants.controllers;

import com.gestionetudiants.dao.HistoriqueDAO;
import com.gestionetudiants.database.Connexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AvancerEtudiantServlet")
public class AvancerEtudiantServlet extends HttpServlet {

    // Cette méthode va gérer la logique du bouton "Avancer"
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEtudiant = Integer.parseInt(request.getParameter("id_etudiant"));

        // Établir la connexion à la base de données
        Connection con = null;
        try {
            con = Connexion.getConnection();
            HistoriqueDAO historiqueDAO = new HistoriqueDAO(con);
            historiqueDAO.avancerEtudiant(idEtudiant);

            // Rediriger vers la page précédente après la mise à jour
            String retour = request.getParameter("retour");
            response.sendRedirect(retour); // Redirige vers la page FSI.jsp, HEC.jsp, etc.

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Erreur lors de la mise à jour de l'étudiant.");
        } finally {
            // Assurez-vous de fermer la connexion
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
