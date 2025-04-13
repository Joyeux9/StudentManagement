<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Créer un étudiant</title>
    <link rel="stylesheet" href="css/createStudent.css"> <!-- Lien vers le fichier CSS -->
</head>
<body>

    <%@ include file="dashboardnavbar.jsp" %> <!-- Inclusion de la navbar -->

    <!-- Conteneur principal avec flexbox -->
    <div class="main-container">

        <!-- 📂 Menu latéral -->
        <div class="sidebar">
            <%@ include file="dashboardsidebar.jsp" %>
        </div>

        <!-- 📂 Conteneur principal -->
        <div class="container">
            <h2>Création d'un étudiant</h2>

            <!-- Affichage du message -->
            <% if (request.getAttribute("message") != null) { %>
                <p class="message"><%= request.getAttribute("message") %></p>
            <% } %>

            <form action="CreateStudentServlet" method="post">
                <!-- Nom -->
                <label for="nom">Nom :</label>
                <input type="text" id="nom" name="nom" required>

                <!-- Prénom -->
                <label for="prenom">Prénom :</label>
                <input type="text" id="prenom" name="prenom" required>

                <!-- Date de naissance -->
                <label for="dateNaissance">Date de Naissance :</label>
                <input type="date" id="dateNaissance" name="dateNaissance" required>

                <!-- Genre -->
                <label for="genre">Genre :</label>
                <select id="genre" name="genre">
                    <option value="M">M</option>
                    <option value="F">F</option>
                </select>

                <!-- Note obtenue -->
                <label for="note">Note Obtenue :</label>
                <input type="number" id="note" name="note" step="0.1" required>

                <!-- Faculté -->
                <label for="faculte">Faculté :</label>
                <select id="faculte" name="faculte">
                    <option value="TIC">TIC</option>
                    <option value="FSI">FSI</option>
                    <option value="FSE">FSE</option>
                    <option value="HEC">HEC</option>
                </select>

                <!-- Département -->
                <label for="departement">Département :</label>
                <select id="departement" name="departement">
                    <option value="TIC">TIC</option>
                    <option value="FSI">FSI</option>
                    <option value="FSE">FSE</option>
                    <option value="HEC">HEC</option>
                    <option value="GL">GL</option>
                    <option value="RT">RT</option>
                    <option value="GC">GC</option>
                    <option value="GE">GE</option>
                    <option value="EPA">EPA</option>
                    <option value="SE">SE</option>
                    <option value="CB">CB</option>
                    <option value="CCA">CCA</option>
                    <option value="FBA">FBA</option>
                    <option value="MM">MM</option>
                </select>

                <!-- Bouton de soumission -->
                <button type="submit" class="btn-submit">Créer</button>
            </form>
        </div>
    </div>

    <%@ include file="footer.jsp" %> <!-- Inclusion du footer -->

</body>
</html>
