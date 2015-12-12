import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("name", "Andriy");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String password = req.getParameter("password");

        LoginService loginService = new LoginService();
        if (loginService.isValidUser(name, password)){
            User user = loginService.getUser();
            req.setAttribute("user", user);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login_success.jsp");
            requestDispatcher.forward(req, resp);
        }else {
            req.setAttribute("validLogin", false);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
