package hanhan.Filter;

import hanhan.Dao.UserDao;
import hanhan.Entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(urlPatterns = "/*", initParams = {@WebInitParam(name="encoding", value = "utf-8")})
public class CharactorFilter implements Filter {
    public void destroy() {
        encoding=null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (encoding != null) {// 判断字符编码是否为空
//            System.out.println(encoding);
            req.setCharacterEncoding(encoding);// 设置request字符编码
            resp.setContentType("text/html; charset = " + encoding);// 设置response字符编码
        }
        chain.doFilter(req, resp);
    }

    String encoding = null;// 字符编码

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");// 获取初始化参数
    }

}
