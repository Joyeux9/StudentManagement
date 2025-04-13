package com.gestionetudiants.controllers;

import com.gestionetudiants.dao.CBDAO;
import com.gestionetudiants.models.Etudiants;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CB")
public class CBServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("🔍 Servlet CBServlet exécuté !");

        // Récupération des étudiants de HEC
        List<Etudiants> etudiants = CBDAO.getEtudiants();
        System.out.println("Nombre d'étudiants trouvés : " + etudiants.size());

        // Envoi des étudiants à la page JSP
        request.setAttribute("etudiants", etudiants);
        request.getRequestDispatcher("CB.jsp").forward(request, response);
    }
}
