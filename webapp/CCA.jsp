<%@ page import="com.gestionetudiants.models.Etudiants" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Étudiants FSI</title>
    <link rel="stylesheet" href="css/fac.css">
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
            <h2>Liste des Étudiants du departement CCA</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Genre</th>
                        <th>Date de Naissance</th>
                        <th>Note</th>
                        <th>Faculté</th>
                        <th>Année Académique</th>
                        <th>Niveau</th>
                        <th>Département</th>
                        <th>Actions</th> <!-- Nouvelle colonne pour le bouton -->
                    </tr>
                </thead>
                <tbody>
                    <% 
                        List<Etudiants> etudiants = (List<Etudiants>) request.getAttribute("etudiants");
                        
                        if (etudiants != null && !etudiants.isEmpty()) {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            for (Etudiants etudiant : etudiants) {
                    %>
                    <tr>
                        <td><%= etudiant.getId_etudiant() %></td>
                        <td><%= etudiant.getNom() %></td>
                        <td><%= etudiant.getPrenom() %></td>
                        <td><%= etudiant.getGenre() %></td>
                        <td><%= dateFormat.format(etudiant.getDateNaissance()) %></td>
                        <td><%= etudiant.getNote() %></td>
                        <td><%= etudiant.getNomfac() %></td>
                        <td><%= etudiant.getDateInscription() %></td>
                        <td><%= etudiant.getNiveauActuel() %></td>
                        <td><%= etudiant.getNomdep() %></td>
                        <td>
                            <div class="actions"> 
                            <form action="AvancerEtudiantServlet" method="post" style="margin:0;">
                                <input type="hidden" name="id_etudiant" value="<%= etudiant.getId_etudiant() %>">
                                <input type="hidden" name="niveau_actuel" value="<%= etudiant.getNiveauActuel() %>">
                                <% if (!"BAC4".equalsIgnoreCase(etudiant.getNiveauActuel())) { %>
                                    <button type="submit" class="Avancer">Avancer</button>
                                <% } else { %>
                                    <span>Final</span>
                                <% } %>
                            </form>
                            <form action="ModifierEtudiantServlet" method="post" style="margin:0;">
                                <button type="submit" class="Modifier">Modifier</button>
                            </form>
                        </div>
                        </td>
                    </tr>
                    <% 
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="11" style="text-align:center;">Aucun étudiant trouvé.</td>
                    </tr>
                    <% 
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Inclusion du footer -->
    <%@ include file="footer.jsp" %>

</body>
</html>
