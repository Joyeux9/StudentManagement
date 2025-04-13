<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Avancer Étudiant</title>
    <link rel="stylesheet" type="text/css" href="css/Avancer.css">  <%-- Lien vers le CSS --%>
</head>
<body>

    <!-- Inclure la barre de navigation -->
      <%@ include file="dashboardnavbar.jsp" %>

    <div class="container">
        <div class="container2">
         <!--Inclure la sidebar -->
        <%@ include file="dashboardsidebar.jsp" %>
        </div>
        <div class="content">
            <h2>Avancer un Étudiant</h2>

            <% if (request.getAttribute("message") != null) { %>
                <p class="message"><%= request.getAttribute("message") %></p>
            <% } %>

            <form action="AvancerEtudiantServlet" method="post">
                <label for="etudiantId">ID de l'Étudiant :</label>
                <input type="number" name="etudiantId" required>

                <button type="submit" class="btn">Avancer</button>
            </form>
        </div>
    </div>
    <%@ include file="footer.jsp" %> <!-- Inclusion du footer -->

</body>
</html>
