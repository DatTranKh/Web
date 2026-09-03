package hcmute.edu.vn.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import hcmute.edu.vn.dao.UserDao;
import hcmute.edu.vn.dao.impl.UserDaoImpl;
import hcmute.edu.vn.entity.User;
import hcmute.edu.vn.service.UserService;
import hcmute.edu.vn.service.impl.UserServiceImpl;
import hcmute.edu.vn.util.Constant;

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 1MB
    maxFileSize = 1024 * 1024 * 10,  // 10MB
    maxRequestSize = 1024 * 1024 * 50 // 50MB
)
@WebServlet(urlPatterns = {"/profile"})
public class ProfileController extends HttpServlet {
    
	private UserDao userDao = new UserDaoImpl();
    private static final String UPLOAD_DIR = "E:\\upload\\users"; // Đường dẫn lưu ảnh thật trên ổ đĩa

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Giả sử lấy user đang đăng nhập có ID = 1 (Trong thực tế lấy từ Session)
        User user = userDao.findById(1);
        request.setAttribute("user", user);
        
        // Forward tới trang JSP trong thư mục views
        request.getRequestDispatcher("/views/web/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        try {
            // Lấy thông tin user hiện tại
            int userId = Integer.parseInt(request.getParameter("id"));
            User user = userDao.findById(userId);

            // Cập nhật thông tin text
            user.setFullName(request.getParameter("fullname"));
            user.setPhone(request.getParameter("phone"));

            // Xử lý upload file ảnh
            Part part = request.getPart("imageFile");
            if (part != null && part.getSize() > 0) {
                String originalFileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                
                // Đổi tên file để tránh trùng lặp
                String fileName = "user_" + userId + "_" + System.currentTimeMillis() + ext;
                
                File uploadDir = new File(UPLOAD_DIR);
                if (!uploadDir.exists()) uploadDir.mkdirs();

                // Lưu file vào ổ đĩa
                part.write(UPLOAD_DIR + File.separator + fileName);
                
                // Lưu tên file vào CSDL
                user.setImages(fileName);
            }

            // Gọi DAO update xuống database
            userDao.update(user);
            
            // Redirect về lại trang profile kèm thông báo
            response.sendRedirect(request.getContextPath() + "/profile?success=true");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/profile?error=true");
        }
    }
}
