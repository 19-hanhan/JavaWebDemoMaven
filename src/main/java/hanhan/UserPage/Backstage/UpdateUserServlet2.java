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

@WebServlet(name = "UpdateUserServlet2", value = "/UpdateUserServlet2")
public class UpdateUserServlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User ur = new User();
        ur.setUsername(request.getParameter("username"));
        ur.setPassword(request.getParameter("password"));
        ur.setStudentId(request.getParameter("studentId"));
        ur.setAge(Integer.valueOf(request.getParameter("age")));
        ur.setPhoneNumber(request.getParameter("phoneNumber"));

        UserDao dao = new UserDao();
        dao.updateUserMessage(ur);
//        request.getRequestDispatcher("/UserData").forward(request, response);
        response.sendRedirect("UserData");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
