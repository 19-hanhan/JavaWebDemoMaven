package hanhan.Filter;

import hanhan.Dao.UserDao;
import hanhan.Entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(urlPatterns = {"/Home", "/MyFile", "/UserData"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null) {
            for(Cookie ck: cookies) {
                if("username".equals(ck.getName()))
                    username = ck.getValue();
                if("password".equals(ck.getName()))
                    password = ck.getValue();
            }
        }
        if (username != null && password != null) { // cookie中存在账号密码，自动登录
            UserDao userDao = new UserDao();
            ArrayList<User> users = userDao.findUserByUsername(username);
            HttpSession session = request.getSession();
            if (users != null && users.get(0).getPassword().equals(password)) {
                session.setAttribute("user", users.get(0));
//                request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
                chain.doFilter(req, resp);
            }
            else {
//                request.getRequestDispatcher("/Login/Error.jsp").forward(request,response);
                response.sendRedirect("Login/Error.jsp");
            }
        }
        else {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("Login/Login.jsp");
            }
            else {
//                request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
