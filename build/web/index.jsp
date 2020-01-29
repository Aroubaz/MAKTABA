<!--

<%-- 
    Document   : index
    Created on : 21 juin 2019, 04:05:28
    Author     : 7 Pro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="projet.css">
        <title>Maktaba</title>
    </head>
    <body id="indexbody">
       <!-- <%
            		                       

        %> -->
        <h1>Welcome to Maktaba!</h1>
        <h2>Search a Book!</h2>
        <form id="indexform" action="Search" method="POST">
           
            <input type="text" name="s" required style="border-radius:10px;">
            <h4 align="center">Search document by</h4>
            <div> 
           	<input type="radio" name="searchby" value="stitle" required style="position: absolute; margin-left: -15px"><label>Title</label>
            </div>
           	<br>
           	<div>
            <input type="radio" name="searchby" value="sauthor" required><label>Author</label>
            </div>
            <br>
            </div>
            <input type="radio" name="searchby" value="stheme" required><label>Theme</label>
            </div>
            <br>
            <br>
            <div>
            <input type="submit" style="border-radius:10px;color: green;font-size: 15px;" value="Submit">
            </div>
            
        </form>
        <br>
        <!--
        <form  action="authen" method="POST">
                <input type="submit" value="Add book/author!">
            </form>
            --->
        <div align="center">
        <button style="border-radius:10px;color: green;">
            <a href="authen" style="color: green;font-size: 15px;">Add book/author!</a>
        </button>
        </div>
        <br>
        <form id="indexform2" action="logout" method="post">
      <input id="logoutbutt" type="submit" value="Logout" style="border-radius:10px;">
   </form>
    </body>
</html>
