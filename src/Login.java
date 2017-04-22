import sun.security.krb5.internal.AuthorizationData;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Map;


public class Login extends javax.servlet.http.HttpServlet {
    private Map<String, Boolean> authors;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        FillUsers users = new FillUsers();
        users.UsersList();
        authors = users.getAuthors();

        String name = request.getParameter("name");
        String pw = request.getParameter("pw");

        if(authors.containsKey(name + ":" + pw)){
            Cookie loginCookie = new Cookie("name", name);
            loginCookie.setMaxAge(60*60);
            response.addCookie(loginCookie);
            response.sendRedirect("main.jsp");
        } else{
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Incorrect username or password, try it again!');");
            out.println("location='index.jsp';");
            out.println("</script>");


        }

    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
    private boolean validAuthor(String auth){
        if(auth == null){
            return false;
        }
        if(!auth.toUpperCase().startsWith("BASIC")){
            return true;
        }
        String decode = new String(Base64.getDecoder().decode(auth.substring(6)));
        return authors.get(decode);
    }


}
