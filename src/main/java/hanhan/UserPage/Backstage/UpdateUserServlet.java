package hanhan.UserPage.Backstage;

import hanhan.Dao.UserDao;
import hanhan.Entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdateUserServlet", value = "/UpdateUserServlet")
public class UpdateUserServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html; charset=UTF-8");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        UserDao dao = new UserDao();
        ArrayList<User> lsUser = dao.findUserByUsername(request.getParameter("username"));
        User ur = lsUser.get(0);
        request.setAttribute("updateUser", ur);
        request.getRequestDispatcher("/WEB-INF/Backstage/UpdateUser.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
