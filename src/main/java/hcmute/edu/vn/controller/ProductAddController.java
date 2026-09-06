package hcmute.edu.vn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/product/add"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB[cite: 4]
                 maxFileSize = 1024 * 1024 * 10,      // 10MB[cite: 4]
                 maxRequestSize = 1024 * 1024 * 50)   // 50MB[cite: 4]
public class ProductAddController extends HttpServlet {
    
    private static final String UPLOAD_DIRECTORY = "E:\\upload";

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "default.file";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        
        String uploadPath = File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        String fileName = "";
        try {
            Part part = request.getPart("imageFile"); // Lấy file upload theo tên Field[cite: 4]
            if (part != null && part.getSize() > 0) {
                fileName = getFileName(part);
                part.write(uploadPath + File.separator + fileName);
            }
            
            // Gọi ProductDAO để thực hiện lệnh INSERT INTO Products...
            // productDao.insert(new Product(productName, price, fileName, categoryId));
            
            response.sendRedirect(request.getContextPath() + "/admin/products");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
