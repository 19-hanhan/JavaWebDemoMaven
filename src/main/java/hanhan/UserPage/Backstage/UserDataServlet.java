package hanhan.UserPage.Backstage;

import hanhan.Dao.UserDao;
import hanhan.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserDataServlet", value = "/UserData")
public class UserDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        ArrayList<User> lsUser = dao.findAllUser();
        request.setAttribute("lsUser", lsUser);
        request.getRequestDispatcher("/WEB-INF/Backstage/UserData.jsp").forward(request, response);
    }
}
