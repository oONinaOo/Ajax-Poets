import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
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

}
