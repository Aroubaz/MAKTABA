/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 7 Pro
 */
public class addbook extends HttpServlet {

protected void doPost(HttpServletRequest r , HttpServletResponse s ) throws ServletException, IOException{
       
        String titre = r.getParameter("titre");
        String resume = r.getParameter("resume");
        int  nbpage = Integer.parseInt(r.getParameter("nbpage"));
        String domaine = r.getParameter("domaine");
        String auteur = r.getParameter("auteur");

        try {
        Class.forName("com.mysql.jdbc.Driver");
            Connection c;
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktaba", "root","");
            ResultSet resultats = null;
            // on selectionne le nom de l'autre pour voir s"il existe 
            String requete = "SELECT * FROM author WHERE Nom = '" + auteur +"' ;";
            Statement stmt = c.createStatement();
            resultats = stmt.executeQuery(requete);
            // on selectionne le nom de l'autre pour voir s"il existe 
            
            
            // on verifier si la requete SQL a retourné une valeur ; si l'auteur existe alors on ajoute le livre 
            if(resultats.next()){
                // numero de l'auteur 
               int numauteur = resultats.getInt("num");
                
                String requete2;
                ResultSet resultats1;

            
            requete2 = "INSERT INTO book (`Titre`, `Resume`, `NbPage`, `domaine`) VALUES  (?,?,?,?);";
                PreparedStatement pr = c.prepareStatement(requete2);
                pr.setString(1, titre);
                pr.setString(2, resume);
                pr.setInt(3, nbpage);
                pr.setString(4, domaine);
                pr.executeUpdate();
                
              // recuperation du ISSN du libre ajouter
              String rqt = "SELECT * FROM book WHERE Titre = '"+titre+"' ;";
              Statement stmt2 = c.createStatement();
               System.out.println(rqt);
            resultats1 = stmt2.executeQuery(rqt);
            System.out.println("rana hna 1");
            System.out.println(resultats1.next());
            int issn = resultats1.getInt("ISSN");
            
            System.out.println("rana hna 2");
            
            
             
             //Insertion dans la table Ecrit 
         
                 String requete4 = "INSERT INTO ecrit (`ISSNB`, `NumA`) VALUES  (?,?);";
                System.out.println("rana hna 4");
                PreparedStatement pr4 = c.prepareStatement(requete4);
                System.out.println("rana hna 5");
                pr4.setInt(1, issn);
                pr4.setInt(2, numauteur);
                System.out.println("rana hna 6");
                pr4.executeUpdate();
                System.out.println("rana hna 7");
              
               //Insertion dans la table Ecrit 
              
                RequestDispatcher rd = r.getRequestDispatcher("index.jsp");
            rd.forward(r, s);
            
            
            
            // Si l'auteur n'existe pas on garde les données de notre livre avec setAttribute on les envoi apre a la page jsp
            // pour ajouter l'auteur manqauant 

            }else{
                r.setAttribute("titre", titre);
            r.setAttribute("resume", resume);
                r.setAttribute("nbpage", nbpage);
                    r.setAttribute("domaine", domaine);
                RequestDispatcher rd = r.getRequestDispatcher("addauteur.jsp");
         rd.forward(r, s);
            }
            
    } catch (Exception e) {
    }
        
    }
}
