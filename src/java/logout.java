
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class logout extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    
   protected void doPost(HttpServletRequest r, HttpServletResponse s) throws ServletException, IOException {
       // la on se deconnecte on detruit cookie
       Cookie ck=new Cookie("auth","");  
           ck.setMaxAge(0);
           s.addCookie(ck); 
           RequestDispatcher rd = r.getRequestDispatcher("index.jsp");
            rd.forward(r, s);
          
   }

}