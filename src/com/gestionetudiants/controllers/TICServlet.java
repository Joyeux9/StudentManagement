package com.gestionetudiants.controllers;

import com.gestionetudiants.dao.TICDAO;
import com.gestionetudiants.models.Etudiants;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TIC")
public class TICServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("🔍 Servlet TICServlet exécuté !");

        try {
            // Récupération des étudiants de TIC
            List<Etudiants> etudiants = TICDAO.getEtudiants();
            System.out.println("Nombre d'étudiants trouvés : " + etudiants.size());

            if (etudiants.isEmpty()) {
                request.setAttribute("message", "Aucun étudiant trouvé pour la faculté TIC.");
            } else {
                // Envoi des étudiants à la page JSP
                request.setAttribute("etudiants", etudiants);
            }

            // Redirection vers la page JSP avec les étudiants ou message d'erreur
            request.getRequestDispatcher("TIC.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            // Si une erreur se produit, envoie un message d'erreur
            request.setAttribute("message", "Erreur lors de la récupération des étudiants.");
            request.getRequestDispatcher("TIC.jsp").forward(request, response);
        }
    }
}
