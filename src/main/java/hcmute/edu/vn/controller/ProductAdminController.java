package hcmute.edu.vn.controller;

import hcmute.edu.vn.dao.impl.ProductDaoImpl;
import hcmute.edu.vn.entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.File;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25) //[cite: 4]
public class ProductAdminController extends HttpServlet {
    private ProductDaoImpl productDao = new ProductDaoImpl();

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) { //[cite: 3]
            if (content.trim().startsWith("filename")) //[cite: 3]
                return content.substring(content.indexOf("=") + 2, content.length() - 1); //[cite: 3]
        }
        return "default.file"; //[cite: 3]
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        Product product = new Product();
        product.setProductName(req.getParameter("productName"));
        product.setPrice(Double.parseDouble(req.getParameter("price")));
        
        String uploadPath = "E:\\upload"; //[cite: 3]
        File uploadDir = new File(uploadPath); //[cite: 3]
        if (!uploadDir.exists()) uploadDir.mkdir(); //[cite: 3]

        Part part = req.getPart("imageFile"); //[cite: 4]
        if (part != null && part.getSize() > 0) { //[cite: 4]
            String fileName = getFileName(part); //[cite: 3]
            part.write(uploadPath + File.separator + fileName); //[cite: 3]
            product.setImages(fileName);
        }

        productDao.insert(product);
        resp.sendRedirect(req.getContextPath() + "/admin/products");
    }
}