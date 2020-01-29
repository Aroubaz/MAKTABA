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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 7 Pro
 */
public class login extends HttpServlet {
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
protected void doPost(HttpServletRequest r , HttpServletResponse s ) throws ServletException, IOException{
        String user = r.getParameter("user");
        String pwd = r.getParameter("pwd");
        
        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktaba", "root","");
        ResultSet login = null;
        String rqt = "SELECT User FROM user WHERE User = ? AND Password = ? ";
        PreparedStatement p = c.prepareStatement(rqt);
        p.setString(1, user);
        p.setString(2, pwd);
       
        login = p.executeQuery();
        if (login.next()){
            // si le nom de l'utilisateur et le mot de passe sont correcte on créé un Cookie ck pour garder la connexion 
             Cookie ck = new Cookie("auth", user);
		ck.setMaxAge(-1);
                s.addCookie(ck);
            RequestDispatcher rd = r.getRequestDispatcher("add.jsp");
            rd.forward(r, s);
        }
        else{
            // sinon on le renvoi vers la page de login on ajoutant le message de l'echec de connexion  
        RequestDispatcher rd = r.getRequestDispatcher("login.jsp");
        rd.include(r, s);
        PrintWriter pw = s.getWriter();
        pw.print("<h2 style='color:red;'>Connection Failed</h2>");
        }
        } catch (Exception e) {
    }
        
    }

}