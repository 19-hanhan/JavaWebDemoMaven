package hanhan.UserPage.FileOption;

import com.google.protobuf.ByteString;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UploadServlet", value = "/Upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/MyFile");
//        System.out.println("path = " + path);


        // 设定硬盘缓冲区
        DiskFileItemFactory disk = new DiskFileItemFactory();
//        disk.setRepository(new File("d:/")); // 可以不要，有默认的
//        disk.setSizeThreshold(10227*4); // 可以不要，有默认的

        // 创建解析对象
        ServletFileUpload upload = new ServletFileUpload(disk);
        upload.setHeaderEncoding("UTF-8");
        upload.setSizeMax(1024*1024*5);
        List<FileItem> ls = null;
        try {
            ls = upload.parseRequest(request); // 解析成文件数组
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        // 处理一个文件
        FileItem item = ls.get(0);
        String name = item.getName();
        name = name.substring(name.lastIndexOf("\\") + 1);
//        System.err.println("去除路径的文件名：" + name);
        String exname = name.substring(name.lastIndexOf("."));
        InputStream in = item.getInputStream(); // 得到文件字节流
//        OutputStream out = new FileOutputStream(new File(path + "/"  + UUID.randomUUID().toString() + exname));
        OutputStream out = new FileOutputStream(new File(path + "/"  + name));

        int size = in.available();
        byte[] bt = new byte[1024];
        int len = 0;
        while((len = in.read(bt)) != -1) {
            out.write(bt, 0, len);
        }

        // 成功反馈
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        response.getWriter().print("文件：" + name + "，上传成功；大小：" + size + "B");
        out.close();
        in.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
