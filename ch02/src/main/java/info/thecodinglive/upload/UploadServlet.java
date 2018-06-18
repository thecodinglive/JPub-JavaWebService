package info.thecodinglive.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(urlPatterns = "/upload", name = "uploadServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2mb
        maxFileSize = 1024 * 1024 * 10, // 10mb
        maxRequestSize = 1024 * 1024 * 50, //50mb
        location = "c:/upload" //파일저장위치
)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //경로
        final String path = request.getParameter("destination");
        //파일
        final Part filePart = request.getPart("file");
        //파일이름
        final String fileName = getFileName(filePart);
        final PrintWriter writer = response.getWriter();

        try (OutputStream out = new FileOutputStream(new File(path + File.separator + fileName)); InputStream filecontent = filePart.getInputStream()) {
            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            writer.print("new File: " + fileName + path + "에 생성되었습니다.");

        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        }
    }


    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("Part Header = {0}" + partHeader);
        for (String content: part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}