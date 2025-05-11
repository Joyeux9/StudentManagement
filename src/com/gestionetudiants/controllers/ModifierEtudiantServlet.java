package com.gestionetudiants.controllers;

import com.gestionetudiants.dao.EtudiantDAO;
import com.gestionetudiants.database.Connexion;
import com.gestionetudiants.models.Etudiants;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;

@WebServlet("/ModifierEtudiantServlet")
public class ModifierEtudiantServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (Connection con = Connexion.getConnection()) {
            EtudiantDAO dao = new EtudiantDAO(con);

            int id = Integer.parseInt(request.getParameter("ID"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String genre = request.getParameter("genre");
            String dateNaissanceStr = request.getParameter("dateNaissance");
            String nomfac = request.getParameter("nomfac");
            String nomdep = request.getParameter("nomdep");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Etudiants etu = new Etudiants();
            etu.setId_etudiant(id);
            etu.setNom(nom);
            etu.setPrenom(prenom);
            etu.setGenre(genre);
            etu.setDateNaissance(sdf.parse(dateNaissanceStr));
            etu.setNomfac(nomfac); // Faculté
            etu.setNomdep(nomdep); // Département

            boolean success = dao.updateEtudiant(etu);
            if (success) {
                response.sendRedirect(".jsp"); // Redirige vers la page avec la liste
            } else {
                response.getWriter().write("Échec de la mise à jour de l'étudiant.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Erreur lors de la mise à jour de l'étudiant.");
        }
    }
}
