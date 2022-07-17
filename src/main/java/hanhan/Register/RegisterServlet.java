package hanhan.Register;

import hanhan.Dao.UserDao;
import hanhan.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset = UTF-8");

        // 获取注册数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeat = request.getParameter("repeat");
        System.out.println("password = " + password);
        System.out.println("repeat = " + repeat);
        if (!repeat.equals(password)) {
            System.out.println("密码输入不一致");
            request.getRequestDispatcher("/Login/Error.jsp").forward(request, response);
            return;
        }
        User user = new User(username, password);

        // 结果反馈
        UserDao dao = new UserDao();
        try {
            if(user.getUsername() != "" && user.getPassword() != "" && dao.insertUser(user) == 1){
                System.out.println("注册成功");
//                request.getRequestDispatcher("/Login/Success.jsp").forward(request, response);
                response.sendRedirect("Login/Success.jsp");
            }
            else{
                System.out.println("注册失败");
//                request.getRequestDispatcher("/Login/Error.jsp").forward(request, response);
                response.sendRedirect("Login/Error.jsp");
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        // 从定向
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
    }
}
