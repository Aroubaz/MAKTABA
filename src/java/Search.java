/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Driver;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author 7 Pro
 */
public class Search extends HttpServlet {

    protected void doPost(HttpServletRequest r, HttpServletResponse s ) throws ServletException, IOException{
        String search = r.getParameter("s");
        String searchby = r.getParameter("searchby");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c;
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktaba", "root","");
            ResultSet resultats = null;
        if (searchby.equals("stitle")) {
            String requete = "SELECT Titre,Resume,NbPage,domaine,Nom FROM book,author,ecrit WHERE Titre = ? and num=NumA and ISSNB = ISSN ;";
             PreparedStatement p1 = c.prepareStatement(requete);
             p1.setString(1, search);
            resultats = p1.executeQuery();
            
      
        }
        else if(searchby.equals("sauthor")){
            String requete = "SELECT Titre,Resume,NbPage,domaine,Nom FROM author , book, ecrit WHERE Nom = ? and num=NumA and ISSNB = ISSN;";
            PreparedStatement p1 = c.prepareStatement(requete);
            p1.setString(1, search);
            resultats = p1.executeQuery();
            
        } 
        
        else {
            String requete = "SELECT * FROM book WHERE domaine = ?  ;";
            PreparedStatement p1 = c.prepareStatement(requete);
            p1.setString(1, search);
            System.err.println(requete);
            resultats = p1.executeQuery();
            
            }
       System.out.println("4");
        RequestDispatcher rd = r.getRequestDispatcher("result.jsp");
         rd.include(r, s);
         PrintWriter p = s.getWriter();
         // resultat de la recherche 
          p.print("<table class='table-style-one'>");
          p.print("<tr><th>Titre</th><th>Resume</th><th>Nombre de page</th> <th>Domaine</th><th>Auteur</th> </tr>");
            while (resultats.next()) {
               int i = 1;
               p.print("<tr>");
               while(i<6){
                   p.print("<td>");
                    p.print(resultats.getString(i));
                    p.print("</td>");
                    i++;
                }
               p.print("</tr>");
                
            }
            p.print("</table>");
        
        
        
        } catch (ClassNotFoundException | SQLException e) { 
        }
    }
}
