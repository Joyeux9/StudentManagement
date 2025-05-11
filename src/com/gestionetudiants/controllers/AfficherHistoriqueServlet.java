package com.gestionetudiants.controllers;

import com.gestionetudiants.dao.AfficheHistoriqueDAO;
import com.gestionetudiants.database.Connexion;
import com.gestionetudiants.models.Historique;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/AfficherHistoriqueServlet")
public class AfficherHistoriqueServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (Connection con = Connexion.getConnection()) {
            AfficheHistoriqueDAO dao = new AfficheHistoriqueDAO(con);
            List<Historique> historiques = dao.getAllHistorique();

            request.setAttribute("historiques", historiques);
            request.getRequestDispatcher("historique.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Erreur lors de la récupération de l'historique");
        }
    }
}
