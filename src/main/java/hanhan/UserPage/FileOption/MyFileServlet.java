package hanhan.UserPage.FileOption;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MyFileServlet", value = "/MyFile")
public class MyFileServlet implements Servlet {

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
        ArrayList<String> filenames = getFileName(request.getServletContext().getRealPath("/MyFile"));
        request.setAttribute("filenames", filenames);
        request.getRequestDispatcher("/WEB-INF/FileOption/MyFile.jsp").forward(request,response);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    public ArrayList<String> getFileName(String path) {
        File root = new File(path);
        if (!root.exists()) {
            System.out.println(path + " not exists");
            return null;
        }

        ArrayList<String> filenames = new ArrayList<>();
        File fs[] = root.listFiles();
        for (int i = 0; i < fs.length; i++) {
            File f = fs[i];
            if (f.isDirectory()) {
                System.out.println(f.getName() + " is Directory");
            } else {
//                System.out.println(f.getName());
                filenames.add(f.getName());
            }
        }

        return filenames;
    }
}
