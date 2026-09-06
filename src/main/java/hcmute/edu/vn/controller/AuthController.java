package hcmute.edu.vn.controller;

import hcmute.edu.vn.dao.impl.UserDaoImpl;
import hcmute.edu.vn.entity.User;
import hcmute.edu.vn.util.EmailUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = {"/register", "/verify", "/forgot-password"})
public class AuthController extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/login")) {
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else if (path.equals("/register")) {
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        } else if (path.equals("/verify")) {
            req.getRequestDispatcher("/views/verify.jsp").forward(req, resp);
        } else if (path.equals("/forgot-password")) {
            req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        
        if (path.equals("/register")) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            
            User user = new User();
            user.setEmail(email);
            user.setPassword(password); // Nên mã hóa BCrypt thực tế
            user.setActive(false);
            
            String otp = EmailUtil.generateOTP();
            user.setOtpCode(otp);
            user.setOtpExpiry(new Date(System.currentTimeMillis() + 5 * 60 * 1000)); // 5 phút
            
            userDao.insert(user);
            EmailUtil.sendEmail(email, "Mã xác thực OTP", "Mã OTP của bạn là: " + otp);
            
            req.getSession().setAttribute("tempEmail", email);
            resp.sendRedirect(req.getContextPath() + "/verify");
            
        } else if (path.equals("/verify")) {
            String email = (String) req.getSession().getAttribute("tempEmail");
            String otp = req.getParameter("otp");
            
            User user = userDao.findByEmail(email); // Bạn cần bổ sung hàm findByEmail trong UserDao
            if (user != null && user.getOtpCode().equals(otp) && user.getOtpExpiry().after(new Date())) {
                user.setActive(true);
                userDao.update(user);
                resp.sendRedirect(req.getContextPath() + "/login?msg=success");
            } else {
                resp.sendRedirect(req.getContextPath() + "/verify?error=invalid");
            }
            
        } else if (path.equals("/login")) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            
            User user = userDao.findByEmail(email);
            if (user != null && user.getPassword().equals(password) && user.isActive()) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/home");
            } else {
                resp.sendRedirect(req.getContextPath() + "/login?error=true");
            }
        }
    }
}