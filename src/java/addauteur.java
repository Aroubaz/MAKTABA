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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 7 Pro
 */
public class addauteur extends HttpServlet {

protected void doPost(HttpServletRequest r , HttpServletResponse s ) throws ServletException, IOException{
       
    // on recupere tous les valeur donnée des auteur + les donnée su livre 
        String nom = r.getParameter("nom");
        String prenom = r.getParameter("prenom");
        String datenes = r.getParameter("datenes");
        String titre = r.getParameter("titre");
            String resume = r.getParameter("resume");
            String  nbpage1 = r.getParameter("nbpage");
            int nbpage = Integer.valueOf(nbpage1);
            String domaine = r.getParameter("domaine");
            

        try {
        Class.forName("com.mysql.jdbc.Driver");
            Connection c;
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktaba", "root","");
            
            //Insertion d'auteur    
                String requete2;
            requete2 = "INSERT INTO author (`Nom`, `Prenom`, `DateNes`) VALUES  (?,?,?);";
                PreparedStatement pr = c.prepareStatement(requete2);
                pr.setString(1, nom);
                pr.setString(2, prenom);
                pr.setString(3, datenes);
               
                pr.executeUpdate();
            //Insertion d'auteur
            
            //Numero d'auteur
            ResultSet resultats = null;
            ResultSet resultats1;
            String requete = "SELECT * FROM author WHERE Nom = '" + nom +"' ;";
            Statement stmt = c.createStatement();
            resultats = stmt.executeQuery(requete);
           if(resultats.next()){
            int numauteur = resultats.getInt("num");
           
            //Numero d'auteur
            
            //Insertion livre
            
            String requete3 = "INSERT INTO book (`Titre`, `Resume`, `NbPage`, `domaine`) VALUES  (?,?,?,?);";
                PreparedStatement pr1 = c.prepareStatement(requete3);
                pr1.setString(1, titre);
                pr1.setString(2, resume);
                pr1.setInt(3, nbpage);
                pr1.setString(4, domaine);
                pr1.executeUpdate();
             //Insertion livre
             
             
              // recuperation du ISSN du libre ajouter
                //SELECT * FROM book WHERE Titre = 'AAAAA' ;
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
           }
           
                
            
    } catch (Exception e) {
    }
        
    }

}