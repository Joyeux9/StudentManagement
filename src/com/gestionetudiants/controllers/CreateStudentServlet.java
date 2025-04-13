package com.gestionetudiants.controllers;

import com.gestionetudiants.models.CreateStudent;
import com.gestionetudiants.database.Connexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CreateStudentServlet")
public class CreateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String genre = request.getParameter("genre");
        String dateNaissance = request.getParameter("dateNaissance");
        double note = Double.parseDouble(request.getParameter("note"));
        String faculte = request.getParameter("faculte");
        String departement = request.getParameter("departement");

        // Initialize database connection and handle exceptions
        Connection conn = null;
        try {
            // Open connection to the database
            conn = Connexion.getConnection(); // Assuming you have a method like this in Connexion class

            CreateStudent student = new CreateStudent(nom, prenom, genre, dateNaissance, note, faculte, departement);
            student.enregistrerEtudiant(conn); // Save student to the database

            request.setAttribute("message", "Étudiant créé avec succès !");
        } catch (SQLException e) {
            // Handle SQL exception
            request.setAttribute("message", "Erreur lors de l'enregistrement : " + e.getMessage());
        } finally {
            // Close connection if it was opened
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace(); // Log connection closing error
                }
            }
        }

        // Forward to the result page
        request.getRequestDispatcher("createStudent.jsp").forward(request, response);
    }
}
