package hanhan.UserPage.Backstage;

import hanhan.Dao.UserDao;
import hanhan.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DeleteUserServlet", value = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        dao.deleteUserByUsername(request.getParameter("username"));
//        request.getRequestDispatcher("/UserData").forward(request, response);
        response.sendRedirect("UserData");
    }
}
