<!--<%-- 
    Document   : addauteur
    Created on : 27 juin 2019, 22:40:20
    Author     : 7 Pro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="projet.css">
        <title>Add Author</title>
    </head>
    
    <body id="addauteurbody">
        <h1>Add Author!</h1>
        <form id="addauteurform" action="addauteur" method="post" >
            <h4> First Name </h4>
            <input type="text" name="prenom" style="border-radius:10px;">
            <br>
            <h4> Last Name </h4>
            <input type="text" name="nom" style="border-radius:10px;">
            <br>
            <h4> Birthday </h4>
            <input type="date" name="datenes" style="border-radius:10px;">
            <!-- pour garder les valeurs du livre on les ajoute avec le formilaire de l'auteur 
            le type hidden pour les caache , l'envoi du form vers la servlet addauteur.java-->
            <input type="hidden" name="titre" value="${titre}">
            <input type="hidden" name="resume" value="${resume}">
            <input type="hidden" name="nbpage" value="${Integer.parseInt(nbpage)}">
            <input type="hidden" name="domaine" value="${domaine}">
            
            <br>
            <br>
            <input id="buttaddauteur" type="submit" style="border-radius:10px;">
        </form>
    </body>
</html>
