<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    // Vérifier si l'admin est connecté
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp"); // Rediriger vers login si non connecté
        return;
    }
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - StudentManagement</title>
    <link rel="stylesheet" href="css/dashboard.css">

</head>
<body>

    <!-- 🚀 Navbar -->
    <%@ include file="dashboardnavbar.jsp" %>

    <!-- 📂 Conteneur principal -->
    <div class="main-container">
        <!-- 📂 Menu latéral -->
        <%@ include file="dashboardsidebar.jsp" %>

        <!-- 📌 Contenu principal -->
    <div class="main-content">
    <div class="welcome-box">
        <h2>Bienvenue, <%= username %> !</h2>
        <hr>
    </div>
    </div>

        </div>
    </div>
    <%@ include file="footer.jsp" %> <!-- Inclusion du footer -->

</body>
</html>
