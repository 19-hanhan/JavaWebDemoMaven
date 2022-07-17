package hanhan.Register;

import hanhan.Dao.UserDao;
import hanhan.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset = UTF-8");

        // 获取注册数据
        UserDao dao = new UserDao();
        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        ArrayList<User> users = dao.findUserByUsername(username);
        if (users.size() == 1) { // 判断该用户是否查找到了
            if (users.get(0).getPassword().equals(oldPassword)) { // 判断旧密码是否正确
                if (newPassword != "") {
                    dao.updatePasswordByUsername(username, newPassword); // 更新密码
//                    request.getRequestDispatcher("/Login/Success.jsp").forward(request, response);
                    response.sendRedirect("Login/Success.jsp");
                }
                else {
                    System.out.println("新密码为空");
//                    request.getRequestDispatcher("/Login/Error.jsp").forward(request, response);
                    response.sendRedirect("Login/Error.jsp");
                }
            }
            else {
                System.out.println("旧密码错误");
//                request.getRequestDispatcher("/Login/Error.jsp").forward(request, response);
                response.sendRedirect("Login/Error.jsp");
                return;
            }
        }
        else {
            System.out.println("没有该用户");
//            request.getRequestDispatcher("/Login/Error.jsp").forward(request, response);
            response.sendRedirect("Login/Error.jsp");
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
    }
}
