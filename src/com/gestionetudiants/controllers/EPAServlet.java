package com.gestionetudiants.controllers;

import com.gestionetudiants.dao.EPADAO;
import com.gestionetudiants.models.Etudiants;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EPA")
public class EPAServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("🔍 Servlet EPAServlet exécuté !");

        // Récupération des étudiants de HEC
        List<Etudiants> etudiants = EPADAO.getEtudiants();
        System.out.println("Nombre d'étudiants trouvés : " + etudiants.size());

        // Envoi des étudiants à la page JSP
        request.setAttribute("etudiants", etudiants);
        request.getRequestDispatcher("EPA.jsp").forward(request, response);
    }
}
