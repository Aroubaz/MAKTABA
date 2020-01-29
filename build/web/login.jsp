<!--<%-- 
    Document   : login
    Created on : 24 juin 2019, 12:20:56
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
    <body id="bodylogin">
        <h1>Login!</h1>
        <form id="loginform" action="login" method="post">
            <h4>Username</h4>
            <input type="text" name="user" style="border-radius:10px;">
            <h4>Password</h4>
            <input type="password" name="pwd" style="border-radius:10px;">
            <br>
            <br>
            <input id="buttid"type="submit" style="border-radius:10px;">
        </form>
    </body>
</html>
