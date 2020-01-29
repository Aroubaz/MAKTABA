<!--<%-- 
    Document   : search
    Created on : 21 juin 2019, 04:12:00
    Author     : 7 Pro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="projet.css">
        <title>JSP Page</title>
    </head>
    <body id="addbody">
        <h1>Add book!</h1>
        <form id="monform" action="addbook" method="post" >
            <h4> Title </h4>
            <input type="text" name="titre" style="border-radius:10px;">
            <br>
            <h4> Description </h4>
            <input type="text" name="resume" style="border-radius:10px;">
            <br>
            <h4> Pages </h4>
            <input type="number" name="nbpage" style="border-radius:10px;">
            <br>
            <h4> Field </h4>
            <input type="text" name="domaine" style="border-radius:10px;">
            <br>
            <h4> Author </h4>
            <input type="text" name="auteur" style="border-radius:10px;">        
            <br>
            <br>
            <input  type="submit" style="border-radius:10px; color: green;">
        </form>
    </body>
</html>
