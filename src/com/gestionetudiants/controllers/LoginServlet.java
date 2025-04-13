package com.gestionetudiants.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gestionetudiants.database.Connexion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = Connexion.getConnection()) {
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // ✅ Identifiants corrects → Redirige vers createStudent.jsp
                HttpSession session = request.getSession();
                session.setAttribute("username", username); // Stocke le user en session
                response.sendRedirect("dashboard.jsp");
            } else {
                // ❌ Identifiants incorrects → Message d'erreur affiché dans login.jsp
                request.setAttribute("errorMessage", "❌ Identifiants incorrects !");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "❌ Erreur serveur !");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
