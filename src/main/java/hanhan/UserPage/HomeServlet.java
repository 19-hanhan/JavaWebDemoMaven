package hanhan.UserPage;

import hanhan.Dao.UserDao;
import hanhan.Entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeServlet", value = "/Home")
public class HomeServlet implements Servlet {

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
        request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request,response);

        // 被filter过滤器替代
//        servletResponse.setContentType("text/html; charset=UTF-8");
//        HttpServletRequest request = (HttpServletRequest)servletRequest;
//        HttpServletResponse response = (HttpServletResponse)servletResponse;
//
//        Cookie[] cookies = request.getCookies();
//        String username = null;
//        String password = null;
//        if (cookies != null) {
//            for(Cookie ck: cookies) {
//                if("username".equals(ck.getName()))
//                    username = ck.getValue();
//                if("password".equals(ck.getName()))
//                    password = ck.getValue();
//            }
//        }
//        if (username != null && password != null) { // cookie中存在账号密码，自动登录
//            UserDao userDao = new UserDao();
//            ArrayList<User> users = userDao.findUserByUsername(username);
//            HttpSession session = request.getSession();
//            if (users != null && users.get(0).getPassword().equals(password)) {
//                session.setAttribute("user", users.get(0));
//                request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request,response);
//            }
//            else {
////                request.getRequestDispatcher("/Login/Error.jsp").forward(request,response);
//                response.sendRedirect("Login/Error.jsp");
//            }
//        }
//        else {
//            HttpSession session = request.getSession();
//            User user = (User)session.getAttribute("user");
//            if (user == null) {
//                response.sendRedirect("Login/Login.jsp");
//            }
//            else {
//                request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
//            }
//        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
