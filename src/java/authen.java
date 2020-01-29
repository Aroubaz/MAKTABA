/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
public class authen extends HttpServlet {
    
    protected void doGet(HttpServletRequest r , HttpServletResponse s ) throws ServletException, IOException{
        // la on verifier si l'administrateur est connecte on l'envoi vers la page add.jsp sinon vers la page login 
        Cookie[] cks = r.getCookies();
        if (cks != null) {
               for (int i = 0; i < cks.length; i++) {
                       String name = cks[i].getName();
        
                         if(name.equals("auth")){
                             
                          
                         RequestDispatcher rd = r.getRequestDispatcher("add.jsp");
                         rd.forward(r, s);
                                 }
                         if (i == (cks.length - 1)) // if all cookie are not valid redirect to error page
                             {
                                    s.sendRedirect("login.jsp");
                              }
                                 i++;
                         
               }
        } else{
        s.sendRedirect("login.jsp");
       }
       
}
}