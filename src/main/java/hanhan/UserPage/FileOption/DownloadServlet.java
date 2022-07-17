package hanhan.UserPage.FileOption;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname= request.getParameter("filename");
        String path = getServletContext().getRealPath("/MyFile/");
        FileInputStream in = new FileInputStream(path + fname);
        response.setContentType("multipart/form-data"); // 判断下载类型
        response.setHeader("Content-Disposition", "attachment; filename=" + fname);
        ServletOutputStream out = response.getOutputStream();
        byte[] bt = new byte[1024*8];
        int len = 0;
        while ((len = in.read(bt)) != -1) {
            out.write(bt, 0, len);
        }
        out.flush();
        in.close();
        out.close();
    }
}
