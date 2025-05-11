
<%@ page import="java.util.List" %>
<%@ page import="com.gestionetudiants.models.Historique" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Historique des Étudiants</title>
    <link rel="stylesheet" href="css/fac.css">
    
    </style>
</head>
<body>

    <!-- Inclusion de la barre de navigation -->
    <%@ include file="dashboardnavbar.jsp" %>

    <!-- Conteneur principal (Sidebar + Contenu) -->
    <div class="main-layout">
        <!-- Inclusion de la barre latérale -->
        <%@ include file="dashboardsidebar.jsp" %>

        <!-- Contenu principal -->
        <div class="main-container">
            <h2>Historique des Étudiants</h2>
            <table>
                <tr>
                    <th>ID Étudiant</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Ancien Niveau</th>
                    <th>Nouveau Niveau</th>
                    <th>Date de Changement</th>
                </tr>
                <%
                    try {
                        List<Historique> historiques = (List<Historique>) request.getAttribute("historiques");
                        if (historiques != null && !historiques.isEmpty()) {
                            for (Historique h : historiques) {
                %>
                <tr>
                    <td><%= h.getId_etudiant() %></td>
                    <td><%= h.getNom() %></td>
                    <td><%= h.getPrenom() %></td>
                    <td><%= h.getAncien_niveau() %></td>
                    <td><%= h.getNouveau_niveau() %></td>
                    <td><%= h.getDate_changement() %></td>
                </tr>
                <%
                            }
                        } else {
                %>
                <tr><td colspan="6">Aucun historique trouvé.</td></tr>
                <%
                        }
                    } catch (Exception e) {
                %>
                <tr><td colspan="6">Erreur lors de l'affichage de l'historique : <%= e.getMessage() %></td></tr>
                <%
                    }
                %>
            </table>
        </div>
    </div>

    <!-- Inclusion du footer -->
    <%@ include file="footer.jsp" %>

</body>
</html>
