package hanhan.Register;

import hanhan.Dao.UserDao;
import hanhan.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset = UTF-8");

//        // 判断Cookie中是否有数据
//        String username = null;
//        String password = null;
//        Cookie[] cookies = request.getCookies();
//        for (Cookie item: cookies) {
//            if ("username".equals(item.getName())) {
//                username = item.getValue();
//            }
//            else if ("password".equals(item.getName())) {
//                password = item.getValue();
//            }
//        }

        // 获取注册数据
        UserDao dao = new UserDao();
        String username = request.getParameter("username"); // 输入的账号
        String password = request.getParameter("password"); // 输入的密码
        String verificationCode = request.getParameter("verificationCode"); // 输入的验证码值
        String[] checkboxValue = request.getParameterValues("saved"); // 复选框值

        if (checkboxValue != null) { // 判断是否有选择自动登录，有则用cookie保存
            Cookie ck1 = new Cookie("username", username);
            Cookie ck2 = new Cookie("password", password);
            ck1.setMaxAge(1800);
            ck2.setMaxAge(1800);
            response.addCookie(ck1);
            response.addCookie(ck2);
        }

        ArrayList<User> users = dao.findUserByUsername(username); // 查找用户
        HttpSession session = request.getSession();
        String imageCode = (String)session.getAttribute("verificationCode"); // 获取图片验证码字符串
        if (users.size() == 1) { // 判断该用户是否查找到了
            if (verificationCode.equalsIgnoreCase(imageCode)) { // 判断验证码是否正确
                if (users.get(0).getPassword().equals(password)) { // 判断密码是否正确
                    session.setAttribute("user", users.get(0));
                    System.out.println("登录成功");
//                    request.getRequestDispatcher("/Home").forward(request, response);
                    response.sendRedirect("Home");
                } else {
                    System.out.println("密码错误");
//                    request.getRequestDispatcher("/Login/Error.jsp").forward(request, response);
                    response.sendRedirect("Login/Error.jsp");
                    return;
                }
            }
            else {
                System.out.println("验证码错误");
//                request.getRequestDispatcher("/Login/Error.jsp").forward(request, response);
                response.sendRedirect("Login/Error.jsp");
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
        doPost(request,response);
    }
}
